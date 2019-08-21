#language: pt

Funcionalidade: Realizar operações na Calculadora do SmartPOS

Contexto:
	Dado que execute a aplicação PayStore
	Mas caso aplicação já esteja executada
	Quando acessar o icone Calculadora
	Então deve ser apresentado a gaveta

Esquema do Cenario: Validando funções matemáticas
	Dado que tecle o número "<n1>"
	E que tecle a função matemática "<fm>"
	E que tecle o número "<n2>"
	Quando teclar o botão igual
	Então deve ser apresentado o valor "<resultado>"

Exemplos:
	|  n1    |    fm   |  n2  | resultado |
	|  1     |    +    |  2   | R$ 3,00   |
	|  10    |    +    |  9   | R$ 19,00  |
	|  30    |    -    |  10  | R$ 20,00  |
	|  -5    |    -    |  10  | R$ -15,00 |
