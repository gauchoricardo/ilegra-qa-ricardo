# language: pt
#
#AVALIADOR: Ambos os testes vão "passar" porque ambos são resultados esperados.
#						O primeiro com a consulta de "Mercado" esperando MERCADO e outro com 
#						caracteres aleatórios esperando a mensagem "Nenhum Resultado" 



@pesquisa
Funcionalidade: Testar campo de pesquisa do blog agi
  Eu como um visitante do blog agi
  Quero realizar uma pesquisa
  e analisar o retorno

  Contexto: Acessar o site
    Dado que realizei o acesso ao blog agi

  @pesquisaOK
  Esquema do Cenário: Validar o campo de pesquisa com dados validos clicando em pesquisar
    Quando insiro o texto no campo pesquisa "<pesquisa>"
    E clico em pesquisar
    Então o resultado deverá coincidir com o texto digitado "<mensagem>"

    Exemplos:
      | pesquisa     |mensagem             |
      | Mercado      |Mercado							 |
    
  @pesquisaInexistente
  Esquema do Cenário: Validar funcionalidade de pesquisa com dados invalidos clicando em pesquisar
    Quando insiro o texto no campo pesquisa "<pesquisa>"
    E clico em pesquisar
    Então o resultado deve ser Nenhum resultado "<mensagem>"

    Exemplos:
      | pesquisa     |mensagem             |
      | *)*			     |Nenhum resultado   	 |