package io.github.igordcn.house_manager_api.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import io.github.igordcn.house_manager_api.entities.Category;
import io.github.igordcn.house_manager_api.entities.Expense;

@Component
public class ExpenseQueryRepositoryImpl implements ExpenseQueryRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Page<Expense> findByCategoryAndDestinationAndBankAndDateBetween(UUID categoryId, UUID destinationId,
            UUID bankId, LocalDate dateStart, LocalDate dateEnd, Pageable pageable) {
        
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Expense> query = builder.createQuery(Expense.class);
        Root<Expense> expenseRoot = query.from(Expense.class);

        List<Predicate> predicates = new ArrayList<>();

        if (categoryId != null) {
            Metamodel m = em.getMetamodel();
            EntityType<Expense> entityExpense = m.entity(Expense.class);
            ListJoin<Expense, Category> categoryJoin = expenseRoot.join(entityExpense.getDeclaredList("categories", Category.class));
            predicates.add(builder.equal(categoryJoin.get("id"), categoryId));
        }
        
        if (destinationId != null) {
            predicates.add(builder.equal(expenseRoot.get("destination").get("id"), destinationId));
        }
        
        if (bankId != null) {
            predicates.add(builder.equal(expenseRoot.get("bank").get("id"), bankId));
        }
        
        predicates.add(builder.greaterThanOrEqualTo(expenseRoot.get("date"), dateStart));
        predicates.add(builder.lessThanOrEqualTo(expenseRoot.get("date"), dateEnd));

        var predicatesArray = (Predicate[]) predicates.toArray();
        
        query.select(expenseRoot).where(predicatesArray);

        List<Expense> result = em.createQuery(query)
            .setFirstResult((int) pageable.getOffset())
            .setMaxResults(pageable.getPageSize())
            .getResultList();
        
        CriteriaQuery<Long> queryCount = builder.createQuery(Long.class);
        Root<Expense> expenseCountRoot = queryCount.from(Expense.class);
        queryCount.select(builder.count(expenseCountRoot)).where(predicatesArray);

        long count = em.createQuery(queryCount).getSingleResult();
        
        return new PageImpl<>(result, pageable, count);
        
    }
    
}
