from rest_framework import serializers

from spendings.models import IncomeType, ExpenseType, PeriodicIncome, PeriodicExpense, EffectiveIncome, EffectiveExpense


class IncomeTypeSerializer(serializers.ModelSerializer):
    class Meta:
        model = IncomeType
        fields = "__all__"


class ExpenseTypeSerializer(serializers.ModelSerializer):
    class Meta:
        model = ExpenseType
        fields = "__all__"


class PeriodicIncomeSerializer(serializers.ModelSerializer):
    class Meta:
        model = PeriodicIncome
        fields = "__all__"
        depth = 1


class PeriodicExpenseSerializer(serializers.ModelSerializer):
    class Meta:
        model = PeriodicExpense
        fields = "__all__"
        depth = 1


class EffectiveIncomeSerializer(serializers.ModelSerializer):
    class Meta:
        model = EffectiveIncome
        fields = "__all__"
        depth = 1


class EffectiveExpenseSerializer(serializers.ModelSerializer):
    class Meta:
        model = EffectiveExpense
        fields = "__all__"
        depth = 1
