from django.contrib.auth import get_user_model
from django.db import models


class RegisterBook(models.Model):
    name = models.CharField(max_length=50)
    reference_month = models.PositiveSmallIntegerField()
    reference_year = models.PositiveIntegerField()
    user = models.ForeignKey(get_user_model(), on_delete=models.CASCADE)
