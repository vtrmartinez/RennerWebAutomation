#language:pt
  @Login
  Funcionalidade: Login

    Cenario: Realizar Login
      Dado que esteja na My Store
      Quando acesso a tela de login
      E relizo o login
        | email    | datumqatest@soprock.com |
        | password | datum2021               |
      Entao exibe o nome do usuario "Datum QA Test"