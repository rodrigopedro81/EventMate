# EventMate
Inicial

Bibliotecas externas usadas : Retrofit e Picasso.
Retrofit para facilitar o consumo da API e Picasso para o GET das imagens a partir das URL's.
Criei a interface (InterfaceAPI) para nela criar os métodos http que foram usados no aplicativo.

A classe RecyclerAdapter guarda os métodos e classes responsáveis pelo funcionamento da RecyclerView, 
a partir dela, mais especificamente no método onBindViewHolder, eu criei um OnClickListener para o itemView
que primeiramente navega para um fragmento (EventoFragment) sem conteúdo e depois preenche de conteúdo 
ao enviar os dados do item clicado para a classe do fragment, onde lá ele é 
lido e preenche os componentes (TextViews e ImageView) da nova view. 
Nessa classe do fragment vemos também a opção de Checkin que usa o método POST.

O app funciona para SDK 19 e 29.
A recycler view se preenche automáticamente de acordo com os dados recebidos da API da mesma forma
que as propriedades de OnClickListener e a transição dos dados para o EventoFragment onde podemos 
vê-los com mais detalhes é gerada para qualquer itemView. 
