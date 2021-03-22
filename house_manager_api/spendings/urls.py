from django.urls import path, include
from rest_framework.routers import DefaultRouter

from .views import register_books, transactions

router = DefaultRouter()
router.register(r"incomes", transactions.EffectiveIncomeViewSet, "income")
router.register(r"incomes/periodics", transactions.PeriodicIncomeViewSet, "periodic_income")
router.register(r"incomes/types", transactions.IncomeTypeViewSet, "income_types")
router.register(r"expenses", transactions.EffectiveExpenseViewSet, "expense")
router.register(r"expenses/periodics", transactions.PeriodicExpenseViewSet, "periodic_expense")
router.register(r"expenses/types", transactions.ExpenseTypeViewSet, "expense_types")
router.register(r"register-books", register_books.RegisterBookViewSet, "register_book")

urlpatterns = [
    path("v1/", include(router.urls))
]
