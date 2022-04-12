#language:pt
  @carrinho
  Funcionalidade: Carrinho

  Contexto:
    Dado que esteja logado
      | email    | datumqatest@soprock.com |
      | password | datum2021               |

  Cenario: Adicionar Produtos ao Carrinho
    Dado que esteja na My Store
    Quando seleciono o produto
      | nome                        | quantidade | tamanho | cor   |
      | Printed Chiffon Dress       |            | M       | verde |
      | Faded Short Sleeve T-shirts |            |         | azul  |
      | Blouse                      | 2          |         |       |
      | Printed Dress               |            |         |       |
    Entao valido os "5" itens no carrinho