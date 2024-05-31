# Desafio técnico MultiSearch
O Projeto MultiSearch é uma aplicação web projetada para buscar e exibir dados de várias categorias, como produtos, pedidos de venda, pedidos de compra e força de trabalho. O projeto é composto por uma API backend construída com Java Spring Boot e um frontend construído com React.
### Estrutura do Projeto
#### Backend
- Aplicação **Spring Boot** fornecendo uma API RESTful.
- Lê dados de arquivos JSON que representam diferentes tabelas no sistema.
- Exibe um endpoint de busca para consultar os dados.

#### Frontend
- Aplicação **React** para exibir os dados.
- Utiliza Axios para buscar dados do backend.
- Fornece uma barra de busca para filtrar resultados com base no input do usuário.

#### Pré-requisitos
- Java 
- Node.js
- npm

  ### Configuração do Backend
1. **Clone o Repositório**:
    ```bash
    git clone https://github.com/JosePBNeto/MultiSearch-Challenge.git
    ```
2. **No diretorio src/MultiSerchAPI, instale as dependencias e execute o Backend**:
    ```bash
    ./mvnw clean install  
    ```
   ```bash
   ./mvnw spring-boot:run
   ```
   O backend será iniciado em `http://localhost:8080`.

   ### Configuração do Frontend
1. **No diretório src/multisearch instale as Dependências**:
    ```bash
    npm install
    ```

2. **Inicie o Frontend**:
    ```bash
    npm start
    ```
   O frontend será iniciado em `http://localhost:3000`.

### App
Agora basta pesquisar pela palavra-chave e a aplicação vai filtrar os dados encontrados por categoria.


   
