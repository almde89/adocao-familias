# Adoção Famílas
Projeto beneficente para ajudar famílias carentes. Disponibilizar cadastramento de famílias por qualquer pessoa para que essas famílias possam receber ajuda direta, sem intermediários. 
Faça sua parte você mesmo!

# A ideia
Galera, não só por conta da pandemia, mas já há algum tempo penso em oferecer o melhor que tenho para ajuda ao próximo. E isso seria meu ofício: programação.

Vejo que muitas pessoas têm intenção de ajudar, mas muitas vezes não sabem como. Algumas empresas como Globo já fizeram soluções semelhantes, mas para ajuda de instituições.

Quero poder ajudar cada singular família. E a maneira que eu acho mais viável e segura, além de recompensadora para qualquer pessoa que se dispõe a ajudar é tendo contanto direto com quem é ajudado.

A solução é algo bem simples e nada mirabolante. Sei que muitos vão falar "Ah, mas brasileiro é bixo safado. Vai ter muita gente que não precisa utilizando a solução de maneira indevida". A ideia não é trazer esse tipo de controle pra dentro da solução. Eu quero viabilizar que você, que quer ajudar uma família, possa ter condições de entrar em contato com ela ou com quem a cadastrou para pedir por mais informações e decidir sozinho como ajudar.

Penso que maneira mais rápida e simples seria termos um cadastro que qualquer pessoa possa fazer de famílias, sendo ou não parte integrante dela, colocar suas informações de contato junto com os dados da família. Além de informar o tipo de ajuda necessária. A ideia não é doar dinheiro, pois o dinheiro tem uma só finalidade: ser gasto. Assim cada pessoa que queira ajudar pode comprar ou doar o que quiser, sem precisar de dinheiro envolvido.

Uma pessoa cadastra e várias outras podem ir atrás e decidir ajudar. Para aumentar a confiabilidade do cadastro, penso que cada doador pode fazer uma avaliação da família, além de salientar mais a necessidade de quem está sendo ajudado. Assim teríamos um mecanismo de avaliação das famílias listadas.

A parte mais complexa que penso e que entendo ser necessária são as integrações com redes sociais, para cada interação dessa ser publicada nos perfis das pessoas que se envolvam com a aplicação para promover engajamento. Inclusive, nem penso em fornecer outra maneira de entrar na ferramenta que não seja utilizando o Single Sign-on das redes.


# Estrutura desejada
A ideia é criar uma arquitetura cliente-servidor com microserviços de granularidade espeça. Cada microserviço deve conter em si os mecanismos necessários para manutenção da ACID.

## Web APP (lado do cliente)
No webapp teremos todas as funciolidades para cadastramento, listagem, filtragem de famílias e avaliação quando uma pessoa ajudar.

## Microserviço Família
Seria o grão responsável por cadastrar, listar e avaliar a ajuda realizada às famílias.

Acredito que ao menos uma FOTO por FAMÍLIA seja necessária.

## Microserviço Anjos
Seria o grão responsável por manter as informações das pessoas que estariam cadastrando as famílias necessitadas. É um local para procurarmos os dados de quem ajuda. A relação com a Entidade FAMÍLIA é só com o identificador do ANJO. Cada FAMÍLIA terá relação com um ANJO cadastrador.

O principal objeto deste grão é disponibilizar meios de nos comunicarmos com as pessoas que cadastram, quando decidirmos ajudar uma FAMÍLIA.
