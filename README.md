# Preparação de ambiente no ubuntu
Siga os passos descritos [aqui](https://medium.com/@prog.tiago/preparando-um-ambiente-de-desenvolvimento-no-ubuntu-7c02a84ba6a6)

# Rodar mysql com docker
- Abra um terminal até o diretório onde o arquivo stack.yml está
- Execute o comando:

```
$ docker-compose -f stack.yml up -d
```

# Criar o database 'teste':

- Abra um browser de sua preferência e acesse `http://localhost:8080` para acessar o admin do mysql, com usuário=`root` e senha=`MYSQL_ROOT_PASSWORD` (veja stack.yml);
- Clique no link `Criar Base de Dados` e crie a base `teste`;
- Rodar a aplicação para geração das tabelas;
- Abra uma IDE de seu gosto e se conecte ao banco de dados. Para obter o IP do mysql, rode o comando:

```
$ docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' [CONTAINER_ID]
```
- Adicionar a seguinte massa:

```
insert into tb_authorities values (1, 'ADMIN');
insert into tb_authorities values (2, 'ESPEC');
insert into tb_authorities values (3, 'COMUM');

insert into tb_medicial_indication (medicinal_indication_id, indication) values (1,'teste');
insert into tb_medicial_indication (medicinal_indication_id, indication) values (2,'teste');
insert into tb_medicial_indication (medicinal_indication_id, indication) values (3,'teste');

insert into tb_medicial_contraindication (medicinal_contraindication_id, contraindication) values (1, 'teste');
insert into tb_medicial_contraindication (medicinal_contraindication_id, contraindication) values (2, 'teste');
insert into tb_medicial_contraindication (medicinal_contraindication_id, contraindication) values (3, 'teste');

```

# Configurando a aplicação
- Abra o application.properties e configure o IP de conexão com o banco de dados com o obtido acima;
- Rode a aplicação e acesse `http://localhost:8000/anonymous/homepage`;

