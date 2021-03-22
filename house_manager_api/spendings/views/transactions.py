from rest_framework import viewsets

from spendings.models import PeriodicIncome, PeriodicExpense, IncomeType, ExpenseType, EffectiveExpense, EffectiveIncome
from spendings.serializers.transactions import PeriodicIncomeSerializer, PeriodicExpenseSerializer, \
    IncomeTypeSerializer, ExpenseTypeSerializer, EffectiveExpenseSerializer, EffectiveIncomeSerializer


class IncomeTypeViewSet(viewsets.ModelViewSet):
    queryset = IncomeType.objects.all()
    serializer_class = IncomeTypeSerializer


class ExpenseTypeViewSet(viewsets.ModelViewSet):
    queryset = ExpenseType.objects.all()
    serializer_class = ExpenseTypeSerializer


class PeriodicIncomeViewSet(viewsets.ModelViewSet):
    queryset = PeriodicIncome.objects.all()
    serializer_class = PeriodicIncomeSerializer


class PeriodicExpenseViewSet(viewsets.ModelViewSet):
    queryset = PeriodicExpense.objects.all()
    serializer_class = PeriodicExpenseSerializer


class EffectiveExpenseViewSet(viewsets.ModelViewSet):
    queryset = EffectiveExpense.objects.all()
    serializer_class = EffectiveExpenseSerializer


class EffectiveIncomeViewSet(viewsets.ModelViewSet):
    queryset = EffectiveIncome.objects.all()
    serializer_class = EffectiveIncomeSerializer
