# 🚀 Plataforma de Pagamentos | Desafio Back-end Júnior  

## 📌 Sobre o Projeto  
Este projeto é uma API RESTful para transferências financeiras entre usuários, seguindo os princípios da **Arquitetura Limpa**. Ele permite o cadastro de usuários, valida saldo antes das transações, integra-se com um serviço externo para autorização e envia notificações após cada transferência.  

## 🛠️ Tecnologias Utilizadas  

- **Framework:** [Spring Boot / Java] 
- **Banco de Dados:** [ / MySQL / ] 
- **Docker** *(se aplicável)*  

## 🏛️ Arquitetura do Projeto  
A aplicação foi desenvolvida utilizando **Arquitetura Limpa**, separando regras de negócio, casos de uso e infraestrutura para garantir código modular e de fácil manutenção.  

📂 **Camadas:**  
- **Core:** Entidades e regras de negócio.  
- **Use Cases:** Casos de uso e regras específicas da aplicação.  
- **Adapters:** Controladores, repositórios e serviços externos.  
- **Infra:** Banco de dados, configurações e provedores externos.  

## 🚀 Como Executar  
1. Clone este repositório:  
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio


./mvnw spring-boot:run  # Para Spring Boot  
