# Tarefa 2 - Dockerização de Aplicação Spring Boot

Este repositório contém o desenvolvimento da **Tarefa 2** da disciplina, focado no processo de build, dockerização, testes locais e publicação de uma aplicação Spring Boot no Docker Hub.

> **⚠️ Observação Importante:** Este projeto foi desenvolvido e montado em cima de uma base de código já estruturada anteriormente, recebendo os ajustes necessários para o correto empacotamento e execução em ambiente de container isolado.

---

## 🚀 O que foi feito

### 1. Ajuste e Correção do Endpoint
* Correção do endpoint na classe `AtividadeController`.
* Alteração do mapeamento genérico para `@GetMapping("/atividade")`, garantindo que o servidor identifique explicitamente as requisições HTTP GET realizadas pelo navegador.
* Definição do retorno estático com o nome do aluno: `"Lucas Barros"`.

### 2. Ajustes de Inicialização do Spring Boot (Ambiente Docker)
Para que a aplicação rodasse perfeitamente dentro do container sem a necessidade de subir uma infraestrutura externa de banco de dados neste momento, foram aplicadas as seguintes soluções arquiteturais:
* **Isolamento do Datasource:** Adicionado o parâmetro `exclude = {DataSourceAutoConfiguration.class}` na classe principal `Startup.java` para evitar que a aplicação crashasse tentando buscar metadados de um banco MySQL inexistente no container local.
* **Injeção de Dependência Opcional:** Configuração do `@Autowired(required = false)` no `AlunoRepository` dentro da classe `AlunoController`, impedindo falhas de inicialização do contexto do Spring (`UnsatisfiedDependencyException`).

### 3. Geração do Artefato (Build)
Limpeza de resíduos de compilações anteriores e geração de um novo arquivo `.jar` atualizado utilizando o Maven:
```bash
mvn clean package -DskipTests
4. Dockerização
Criação da imagem Docker baseada no ambiente eclipse-temurin:21-jdk. A imagem foi construída utilizando a nomenclatura obrigatória exigida:

Bash
docker build --no-cache -t tarefa2_iec_springboot:lucasbarros .
5. Teste Local da Aplicação
Execução do container localmente mapeando a porta interna do Tomcat (8080) para a máquina hospedeira:

Bash
docker run -d -p 8080:8080 --name container_tarefa2 tarefa2_iec_springboot:lucasbarros
Validação: O acesso à URL http://localhost:8080/atividade retorna com sucesso a string "Lucas Barros".

6. Publicação no Docker Hub
Vinculação da imagem local ao perfil da nuvem e publicação com tag de versionamento (v2):

Bash
docker tag tarefa2_iec_springboot:lucasbarros lucasbparada/tarefa2_iec_springboot:v2
docker push lucasbparada/tarefa2_iec_springboot:v2
🛠️ Tecnologias Utilizadas
Java 21

Spring Boot 3.x (Web, Data JPA)

Maven

Docker

Docker Hub (Repositório Remoto)

Desenvolvido por Lucas Barros (lucasbparada).
