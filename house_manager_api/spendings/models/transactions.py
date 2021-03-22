from django.contrib.auth import get_user_model
from django.db import models

from spendings.models import RegisterBook

PERIODICITY_CHOICES = [
    ('N', 'None'),
    ('D', 'Daily'),
    ('M', 'Monthly'),
    ('Y', 'yearly'),
]


class Transaction(models.Model):
    title = models.CharField(max_length=50)
    description = models.TextField(blank=True)
    value = models.DecimalField(max_digits=10, decimal_places=2)
    user = models.ForeignKey(get_user_model(), on_delete=models.CASCADE)
    created_at = models.DateTimeField()
    update_at = models.DateTimeField()

    class Meta:
        abstract = True


class ExpenseType(models.Model):
    name = models.CharField(max_length=50)
    icon = models.CharField(max_length=50)


class Expense(Transaction):
    type = models.ForeignKey(ExpenseType, on_delete=models.CASCADE)

    class Meta:
        abstract = True


class IncomeType(models.Model):
    name = models.CharField(max_length=50)
    icon = models.CharField(max_length=50)


class Income(Transaction):
    type = models.ForeignKey(IncomeType, on_delete=models.CASCADE)

    class Meta:
        abstract = True


class PeriodicExpense(Expense):
    periodicity = models.CharField(choices=PERIODICITY_CHOICES, max_length=1)


class PeriodicIncome(Income):
    periodicity = models.CharField(choices=PERIODICITY_CHOICES, max_length=1)


class EffectiveExpense(Expense):
    realization_date = models.DateField()
    register_book = models.ForeignKey(RegisterBook, on_delete=models.CASCADE)


class EffectiveIncome(Income):
    realization_date = models.DateField()
    register_book = models.ForeignKey(RegisterBook, on_delete=models.CASCADE)
