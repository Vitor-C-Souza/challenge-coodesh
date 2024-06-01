# Challenge coodesh
Challenge da coodesh contendo 5 desafios diferentes

## Descrição
Challenge da coodesh feito para o processo seletivo, nele contém 5 desafios diferentes para ser realizado.

## Índice
1. [Tecnologias usadas](#Técnologias-usadas)
2. [Instalação](#instalação)
3. [Rotas da API](#rotas-da-api)
4. [Contribuição](#contribuição)
5. [Autor](#autor)

## Técnologias Usadas
- Java 8
- Spring Boot Web
- Conector MYSQL(e o banco de dados)
- jackson(para desserialização)
- Log4j2(Para ter log no console)
- Lombok(Anotações para encurtar o código deixando mais limpo e fácil de ser lido)
- HttpClient

## Instalação
### Pré-requisitos
- Java 8+
- maven
- docker (opcional)
- mysql (opcional se não tiver docker instalado)

### Passos
1. Clone o repositório:
   ```bash
    git clone https://github.com/Vitor-C-Souza/challenge-coodesh
    cd challenge-coodesh
    ```


Obs.: Precisa ter o mysql instalado e funcionando neste caso

## Rotas da API
### POST /usuario
```bash
  {
        "nome": "Marcos",
        "email": "marcos@email.com",
        "idade": 18,
        "altura": 1.92
  }
```

Cria um usuario novo e salva no banco

#### retorno
```bash
    {
        "id": 1,
        "nome": "Marcos",
        "email": "marcos@email.com",
        "idade": 18,
        "altura": 1.80
    }
```

### GET /usuario
```bash
    [
        {
            "id": 1,
            "nome": "Vítor",
            "email": "vitor@email.com",
            "idade": 26,
            "altura": 1.77
        },
        {
            "id": 4,
            "nome": "Arthur",
            "email": "arthur@email.com",
            "idade": 18,
            "altura": 1.64
        }
    ]
```

Retorna uma lista de usuarios salvos no banco.

### GET /usuario/{id}/id
```bash
    {
        "id": 1,
        "nome": "Vítor",
        "email": "vitor@email.com",
        "idade": 26,
        "altura": 1.77
    }
```
Se substituir o {id} por um salvo no banco por exemplo "2" retornara um usuario salvo.

### GET /usuario/{nome}/nome
```bash
    {
        "id": 1,
        "nome": "Vítor",
        "email": "vitor@email.com",
        "idade": 26,
        "altura": 1.77
    }
```
Se substituir o {nome} por um nome ou parte salvo no banco por exemplo "marcus" retornara todos usuarios com nome marcus ou começando por marcus armazenado no banco.

### PUT /usuario/{id}
#### body
```bash
    {
        "nome": "Vítor",
        "email": "vitor@email.com",
        "idade": 26,
        "altura": 1.77
    }
```
#### retorno
```bash
    {
        "id": 1,
        "nome": "Vítor",
        "email": "vitor@email.com",
        "idade": 26,
        "altura": 1.77
    }
```
Nesta rota atualiza os dados de um usuario do id que você indicar como parametro na url da rota.

### DELETE /usuario/{id}

Substituindo o {id} por um id de um usuario presente no banco ira apagar o dado salvo.

## Contribuição

Contribuições são bem-vindas! Siga os passos abaixo:

1. Fork o repositório.
2. Crie uma nova branch (git checkout -b feature/nova-feature).
3. Commit suas alterações (git commit -m 'Adiciona nova feature').
4. Push para a branch (git push origin feature/nova-feature).
5. Abra um Pull Request.

## Autor

Eu sou uma pessoa apaixonada por técnologia desde criança tendo um computador dentro de casa, portanto sempre me facinou querer saber mais sobre técnologia, até que tive a oportunidade de estudar num técnico de informática junto do ensino médio no instituto técnico da Federal.<p>
Foi paixão a primeira vista e sabia que aquilo era o que eu queria para a minha vida quando programei pela primeira vez, desde então me empenhei desde os 15 anos a melhorar e poder trabalhar com isso o resto da minha vida, sempre tive contato com técnologia as pessoas me incentivavam a seguir a carreira pois realmente tinha habilidade, vontadade e facilidade de aprender sobre técnologia.<p>
Hoje com 26 anos ainda tento seguir esse meu sonho de ser desenvolvedor participar de projetos e ainda mais se tiver envolvendo com a area da saúde, por motivos de que perdi minha mãe a alguns pro cancêr e gostaria de contribuir desenvolvendo uma técnologia que ajuda a descobrir mais cedo possivel esse problema e não ter perigo de perda e ninguem passar pelo o que passei e ter que assistir e não poder ajudar.<p>
