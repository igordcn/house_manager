from django.contrib import admin

from spendings.models import IncomeType, ExpenseType, PeriodicIncome, PeriodicExpense, EffectiveExpense, \
    EffectiveIncome, RegisterBook


class RegisterBookAdmin(admin.ModelAdmin):
    fields = ['name', 'reference_month', 'reference_year', 'user']


class EffectiveExpenseAdmin(admin.ModelAdmin):
    fields = ['title', 'description', 'value', 'user', 'type', 'realization_date', 'register_book']


class EffectiveIncomeAdmin(admin.ModelAdmin):
    fields = ['title', 'description', 'value', 'user', 'type', 'realization_date', 'register_book']


class PeriodicExpenseAdmin(admin.ModelAdmin):
    fields = ['title', 'description', 'value', 'user', 'type', 'periodicity']


class PeriodicIncomeAdmin(admin.ModelAdmin):
    fields = ['title', 'description', 'value', 'user', 'type', 'periodicity']


class IncomeTypeAdmin(admin.ModelAdmin):
    fields = ['name', 'icon']


class ExpenseTypeAdmin(admin.ModelAdmin):
    fields = ['name', 'icon']


admin.site.register(RegisterBook, RegisterBookAdmin)
admin.site.register(EffectiveExpense, EffectiveExpenseAdmin)
admin.site.register(EffectiveIncome, EffectiveIncomeAdmin)
admin.site.register(PeriodicExpense, PeriodicExpenseAdmin)
admin.site.register(PeriodicIncome, PeriodicIncomeAdmin)
admin.site.register(IncomeType, IncomeTypeAdmin)
admin.site.register(ExpenseType, ExpenseTypeAdmin)
