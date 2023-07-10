# myhousebeachbd
Projeto feito para o trabalho final da cadeira de Banco de Dados I e Programação Orientada a Objetos do curso de Sistemas e Mídias Digitais 

## Tema da Aplicação
Basicamente uma OLX ou uma airbnb focado em aluguel de casas de praia no Brasil.

## Resumo do funcionamento da Aplicação
  A aplicação gira em torno do Banco de Dados, sendo basicamente "CRUDs" para cada coluna do BD. 
  Toda interação com a aplicação e com os dados se dá pelo uso de um menu via console/terminal do Java, no qual você escolhe o que você quer fazer com aquela coluna (inserir, listar todos, buscar um,etc), e a partir dessa escolha o fluxo acontece. 
  Cada coluna do Banco de Dados possui um pacote, onde em cada um deles vai ter o seu _main_ para poder "renderizar" o seu menu e prosseguir com a interação individual.

## O que foi usado:
- Linguagem de Programação Java
- Apache Netbeans IDE 18
- PostgreSQL (pgadmin)

## Requisitos do Trabalho de POO
### Herança
- As classes que estão relacionados com a entidade Dono da Casa herdaram das classes da entidade Cliente. Sem contar com as classes que herdaram da classe abstrata Dao

### Associação
- As classes Casa, Cliente e Dono da Casa se relacionam com a Classe EnderecoComp, e a classe telefone com a classe cliente. Também acontece relacionamentos entre as classes de mesmo pacote, etc.

### Interface/Classe Abstrata
- Foi utilizado uma interface e uma classe abstrata na aplicação.

### Polimorfismo
- Foi utilizado na entidade DonoDaCasa e também nas classes que herdam da classe abstrata Dao.

### Public, Protected e Private
- Private foi utlizado nos atributos das classes, protected nos métodos que não tinha necessidade de serem utilizados fora do pacote e public onde se precisava.

### Método e atributo estático
- Nas classes dos "menus" de interação das entidades e na interface InterfaceDao se teve a utilização de métods e atributos estáticos.

## Iniciar a aplicação

### Criar o banco de dados e as tabelas
- Usando o *pgadmin* crie o banco de dados
- Utilizando o _query tool_, insira o código SQL DDL e execute para gerar as tabelas e colunas
  - *Dentro da pasta tem um arquivo .txt chamado "codigo-sql_ddl" precisando só copiar e colar
- Dentro da aplicação configure a URL e senha do Banco
  - *No _package_ "dao" tem uma interface chamada "InterfaceDao" onde se deve colocar o nome e a senha do BD
 
### Aplicação
- A entidade telefone depende da cliente, então deve inserir os usuários primeiro (Podendo ser pela própria aplicação sem problemas).
- O que foi dito acima também vale para a entidade dono da casa, é necessário cadastrar uma casa primeiro, para depois relacionar.
- Cada entidade tem dentro de seus pacotes uma classe com o nome Java, como, por exemplo, CasaJava, ClienteJava, etc, elas que possuem o método main e são os "menus" de interação.
