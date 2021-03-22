from rest_framework import serializers

from spendings.models import RegisterBook


class RegisterBookSerializer(serializers.ModelSerializer):
    class Meta:
        model = RegisterBook
        fields = "__all__"
        depth = 1
