# lab04 — JDBC com PostgreSQL (Supabase)

Este projeto contém os programas Java para conectar, listar, inserir, alterar e
remover registros de uma tabela `produtos` em um banco PostgreSQL hospedado no
Supabase, usando JDBC puro (sem framework).

Estrutura:

```
lab04/
├── lib/                  -> coloque aqui o driver postgresql-42.7.5.jar
├── src/
│   ├── ModuloConexao.java   -> abre a conexão com o banco
│   ├── App.java             -> lista (SELECT) os produtos
│   ├── Inserir.java         -> cria (INSERT) um produto
│   ├── Alterar.java         -> atualiza (UPDATE) um produto
│   └── Remover.java         -> remove (DELETE) um produto
├── create_tabela.sql        -> script para criar a tabela no Supabase
└── README.md
```

## 1. Criar o projeto

Se você ainda não criou a pasta do projeto no seu ambiente (ex.: VS Code):

```
mkdir lab04
cd lab04
mkdir lib src
```

Copie os arquivos deste zip para dentro das pastas correspondentes.

## 2. Baixar o driver do PostgreSQL

```
cd lib
wget https://repo1.maven.org/maven2/org/postgresql/postgresql/42.7.5/postgresql-42.7.5.jar
cd ..
```

## 3. Criar a tabela no Supabase

No painel do Supabase, abra o **SQL Editor** e execute o conteúdo do arquivo
`create_tabela.sql` (cria a tabela `produtos` e insere alguns registros de
exemplo).

## 4. Configurar a conexão

No Supabase: abra seu projeto → botão **Connect** → aba **JDBC** → copie a
URL de conexão exibida lá.

Edite `src/ModuloConexao.java` e substitua:

```java
private static final String URL = "jdbc:postgresql://SEU_HOST:5432/postgres?sslmode=require";
private static final String USUARIO = "SEU_USUARIO";
private static final String SENHA = "SUA_SENHA";
```

pelos valores reais do seu projeto (a URL do Supabase já costuma trazer o
host e a porta corretos; usuário normalmente é `postgres` e a senha é a que
você definiu ao criar o projeto).

> Dica: nunca faça commit da senha real no GitHub. Para a entrega da
> atividade, considere usar variáveis de ambiente ou apenas anotar no
> próprio código que os valores devem ser substituídos por quem for rodar.

## 5. Compilar

```
javac -cp lib/postgresql-42.7.5.jar -d bin src/*.java
```

## 6. Executar cada programa

Listar produtos:
```
java -cp bin:lib/postgresql-42.7.5.jar App
```

Inserir um novo produto:
```
java -cp bin:lib/postgresql-42.7.5.jar Inserir
```

Alterar um produto existente:
```
java -cp bin:lib/postgresql-42.7.5.jar Alterar
```

Remover um produto:
```
java -cp bin:lib/postgresql-42.7.5.jar Remover
```

> No Windows, troque o `:` por `;` no classpath, ex.:
> `java -cp bin;lib/postgresql-42.7.5.jar App`

## 7. Verificar

Rode `App` antes e depois de cada operação (`Inserir`, `Alterar`, `Remover`)
para confirmar que os dados mudaram corretamente no banco.

## 8. Enviar para o GitHub

```
git init
git add .
git commit -m "lab04: CRUD em Java com JDBC e PostgreSQL (Supabase)"
git branch -M main
git remote add origin <URL_DO_SEU_REPOSITORIO>
git push -u origin main
```

Se o repositório já existir, basta:

```
git add .
git commit -m "lab04: CRUD em Java com JDBC e PostgreSQL (Supabase)"
git push
```
