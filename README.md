This project is a microservices-based financial analysis platform that leverages AI to generate insights from real-time financial data. Built with Spring Boot, Spring AI, and Eureka Service Discovery, the system fetches financial statements and allows users to interactively query AI models for detailed financial understanding.

🚀 Features
📈 Financial Data Aggregation
A dedicated financial-service fetches and structures comprehensive income statements, balance sheets, and cash flow data from third-party APIs (e.g., for stocks like GOOG).

🤖 AI-Driven Analysis
The ai-service uses Spring AI integrated with LLMs (e.g., OpenAI, DeepSeek) to answer user-generated questions about financial data, such as "What was Google's net income in 2024?"

🔎 Service Discovery
Microservices are connected through a central discovery-server using Eureka to ensure modularity, scalability, and easy integration.

📤 RESTful API Endpoints
Clean API design for:

/api/financial/statement/{symbol} to fetch financials

/api/ai/analyze to ask natural language questions about that data

💬 LLM Integration via Spring AI
Easily switch between providers like OpenAI, DeepSeek, or OpenRouter by changing configuration.

🛠️ Tech Stack
Java 17, Spring Boot

Spring Cloud Eureka for service discovery

Spring AI for LLM abstraction

WebClient, RestTemplate for API calls

Maven for project management

Postman for endpoint testing
