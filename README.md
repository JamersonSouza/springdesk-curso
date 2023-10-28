# Projeto Spring Desk :rocket:
Este projeto foi desenvolvido a partir das aulas do meu curso no youtube, é a abstração de um portal de chamados (Helpdesk) onde utilizei o framework Spring. Ele conta com autenticação e autorização com Spring Security.

### Instatação :technologist:

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas em sua máquina: 

* Git
* JDK 8 ou Superior
* Maven
* Visual Studio Code
* MySQL 

Em seguida, execute os seguintes comandos em seu terminal para clonar o repositório projeto:

> git clone https://github.com/JamersonSouza/springdesk-curso.git

**PS:** O projeto conta com 2 branch, na master está disponível o projeto completo e finalizado. Na branch **springdesk-started** está disponível o front-end do projeto para os alunos que estão começando o curso agora no Youtube e precisam do template.

> code . //para abrir o projeto no VsCode

### Configuração :wrench:

* **Banco de dados**: será necessário alterar algumas informações no arquivo **application.yml** como por exemplo:  _USERNAME_ e _PASSWORD_ insira seu usuário e senha do banco de dados configurado na instalação do MySQL. Não esqueça que será necessário criar um banco de dados. Sendo assim, abra o MySQL WorkBench e execute o comando:

> CREATE DATABASE springdesk

### Utilização :bulb:

Ao startar a aplicação a mesma irá utilizar o banco em memória H2 e incluir no banco 2 perfils (cliente, técnico) para login utilize as credenciais abaixo:
> E-mail: jamersontest@mail.com <br>
> Senha: 123456789

Ou...

> E-mail: terezatest@mail.com <br>
> Senha: 123456789<br>

### Implementações :white_check_mark:

A aplicação conta com algumas funcionalidades básicas de um CRUD como por exemplo:

 * Sistema de autenticação e autorização.
 * Cadastro de clientes & técnicos.
 * Utilização de perfils para o desenvolvimento com uso de bancos de dados diferente.
 * Edição de clientes & técnicos.
 * Remoção de clientes & técnicos.
 * Upload de imagem para perfil.
 * Criação e gerenciamento de tickets.


