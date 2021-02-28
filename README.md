README.md in Portuguese (br)

# GestaoApp
 Desenvolvido e escrito na linguagem Java, a fim de criar um sistema para gerenciar um evento de treinamento. O sistema contém opção de cadastros, consultas e automatização da lotação de salas e espaços (desafio/teste) [Leia o README]

## ◾ Sobre o desenvolvimento

Escrito na linguagem Java, optando pelo Padrão MVC para o desenvolvimento (padronização na construção), haja vista que com essa modelagem/estrutura permite-se ter uma aplicação dividida em camadas, gerando um código fonte mais organizado e fácil de dar manutenção.

**▫ Cadastro de pessoas**
**▫ Cadastro de salas do evento**
**▫ Cadastro dos espaços de café**
**▫ Consulta de pessoa**
**▫ Consulta de sala**
**▫ Consulta de espaço**


## ◾ Depuração, cuidados e caminho

Baixe o código fonte como preferir:
```
* git clone https://github.com/tharlysdias/GestaoApp.git
* Download ZIP
```

Abrindo o Programa na IDE desejada
```
* Crie uma pasta com o nome que desejar;
* Salve todos os arquivos nesta pasta criada com o nome desejado;
* Com sua IDE aberta abra a pasta criada com os arquivos como um projeto (IntelliJ, NetBeans, Eclipse...);
* Caso seja necessário, importe as bibliotecas;
* Com todos os passos anteriores corretos basta depurar/executar o código (run);
```

Caminho
```
Programa
├── README.md
├── .gitignore
├── GestaoApp
│   └── src
│       └── main
│           └── java
│               └── controller
│                   ├── CoffeSpaceController.java
│                   ├── ConsultDataController.java
│                   ├── EventRoomController.java
│                   └── PersonController.java
│               └── model
│                   ├── CoffeSpace.java
│                   ├── EventRoom.java
│                   └── Person.java
│               └── util
│                   ├── CoffeSpaceTableModel.java
│                   ├── ConsultDataTableModel.java
│                   ├── EventRoomTableModel.java
│                   ├── File.java
│                   ├── FileRoom.java
│                   ├── FileSpace.java
│                   └── PersonTableModel.java
│               └── view
│                   ├── CoffeSpaceScreen.java
│                   ├── ConsultDataScreen.java
│                   ├── EventRoomScreen.java
│                   ├── MenuScreen.java
│                   ├── PersonScreen.java
│                   └── ...
│       └── test
│           └── java
│               └── controller
│                   └── ...
│               └── model
│                   └── ...
│               └── util
│                   └── ...
│   └── .classpath
│   └── .project
│   └── base_de_dados.txt
│   └── base_de_dados_espacos.txt
│   └── base_de_dados_salas.txt
│   └── GestaoApp.iml
│   └── nbactions.xml
│   └── pom.xml
│   └── .settings
│       └── ...
│   └── target
│       └── ...
└── ...
```
Perceba que o código fonte encrontra-se em **src** na *package* **main.java**

*O código fonte possui o padrão MVC*


*Como rodar os testes*
```
* Com o projeto aberto selecione a classe de teste desejada;
* Depure esta classe (Ex.: classe "PersonController.java");
* Pelos comentários verifique exatamente o que está sendo testado;
* Com todos os testes entendidos e verificados, tudo ok!
```
◾ Informações finais
---

* IDE Utilizada: netbeans
* Maven - Gerenciador de dependencias

technologies and Frameworks/libraries:
* *Java JDK 15*
* *ArrayLists*
* *JSON*
* *JUnit*
...

***Desenvolvido por Tharlys de Souza Dias***
