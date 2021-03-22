from rest_framework import viewsets

from spendings.models import RegisterBook
from spendings.serializers.register_books import RegisterBookSerializer


class RegisterBookViewSet(viewsets.ModelViewSet):
    queryset = RegisterBook.objects.all()
    serializer_class = RegisterBookSerializer
