# Endpoints

## /auth

<details>
 <summary><code>POST</code> <code><b>/auth/register</b></code> <code>(cadastro de usuário comum)</code></summary>

### Body

```http
Content-Type: application/json

{
    "name": "nome do usuário",
    "email": "email do usuário",
    "companyId": "id da empresa",
    "password": "senha"
}
```

### Respostas

> | Código HTTP     | Descrição                                                                          |
> |-----------------| ------------
> | 200             | Usuário cadastrado com sucesso
> | 400             | Request mal formada

</details>

<details>
 <summary><code>POST</code> <code><b>/auth/login</b></code> <code>(login de usuário)</code></summary>

### Body

```http
Content-Type: application/json

{
    "email": "email do usuário",
    "password": "senha"
}
```

### Respostas

> | Código HTTP     | Conteúdo        | Descrição
> |-----------------| --------------- | ------------
> | 200             | Token JWT       | Login realizado com sucesso
> | 400             | Problem details | Request mal formada
> | 403             |                 | Credenciais inválidas

</details>

## /company

<details>
 <summary><code>GET</code> <code><b>/company</b></code> <code>(lista as empresas)</code></summary>

### Headers

```http
Content-Type: application/json

Authorization: Bearer {token}
```

### Respostas

> | Código HTTP     | Conteúdo         | Descrição
> |-----------------| ---------------- | ------------
> | 200             | Array de objetos | Retorna as empresas cadastradas
> | 403             |                  | Não autorizado (precisa enviar o token no header)

</details>

<details>
 <summary><code>GET</code> <code><b>/company/{id}</b></code> <code>(busca uma empresa pelo id)</code></summary>

### Headers

```http
Content-Type: application/json

Authorization: Bearer {token}
```

### Respostas

> | Código HTTP     | Conteúdo         | Descrição
> |-----------------| ---------------- | ------------
> | 200             | Objeto           | Empresa encontrada
> | 403             |                  | Não autorizado (precisa enviar o token no header)
> | 404             | Problem details  | Empresa não encontrada

</details>

<details>
 <summary><code>POST</code> <code><b>/company</b></code> <code>(cadastra uma empresa)</code></summary>

### Body

```http
Content-Type: application/json

{
    "name": "nome da empresa"
}
```

### Headers

```http
Content-Type: application/json

Authorization: Bearer {token}
```

### Respostas

> | Código HTTP     | Conteúdo         | Descrição
> |-----------------| ---------------- | ------------
> | 200             | Objeto           | Empresa cadastrada
> | 403             |                  | Não autorizado (precisa enviar o token no header)

</details>

<details>
 <summary><code>DELETE</code> <code><b>/company/{id}</b></code> <code>(deleta uma empresa pelo id)</code></summary>

### Headers

```http
Content-Type: application/json

Authorization: Bearer {token}
```

### Respostas

> | Código HTTP     | Conteúdo         | Descrição
> |-----------------| ---------------- | ------------
> | 200             |                  | Empresa deletada
> | 403             |                  | Não autorizado (precisa enviar o token no header)

</details>