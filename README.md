## Installatie & opstarten

### 1. Clone de repository

```bash
git clone https://github.com/IliasBenFodda/Enterprise-Apps-Ilias.Ben-Fodda.git
cd Enterprise-Apps-Ilias.Ben-Fodda
```

### 2. Voeg een mailtrap account toe

Om gebruik te kunnen maken van de mail van de applicatie moet je een extra `application-local.properties` file toevoegen
aan de
`src/main/resources` map. Deze file moet de volgende properties bevatten om zelf mails te kunnen ontvangen:

```properties
spring.mail.username=Jouw eigen username
spring.mail.password=Jouw eigen password
```

### 3. Start de applicatie

```bash
mvn spring-boot:run
```

### 4. Open in de browser

Ga naar http://localhost:8080

## Gebruikte bronnen

- Contactpagina: https://www.youtube.com/watch?v=tAHxSdyfA1c (mailtrap)
- h2
  database: https://medium.com/@aniruddhasonawane/how-to-set-up-h2-database-in-spring-boot-for-local-development-step-by-step-4591aa7bc9da
- Styling: Github copilot in Intellij (Kan hier niet naar linken)
    - Stijl gekozen en deze gezegd in de chat, deze heeft voor mij alle html pagina's van css voorzien in dezelfde stijl
- Gebruik van dto objecten om data door te geven: https://www.baeldung.com/java-dto-pattern
- Validatie van de formulieren die ik
  gebruik: https://medium.com/@AlexanderObregon/handling-form-submissions-with-spring-boot-using-thymeleaf-30dd41dda76d
- findTop10ByOrderByTijdstipDesc methode in EvenementRepository
    - Vraag gesteld in Intellij aan copilot: "Ik wil een query om de 10 meest recente evenementen op te halen uit de
      database"
- Gebruik van model bij formulieren om data aan pagina te geven: https://www.baeldung.com/thymeleaf-list
- Gebruik van ai voor kleine vragen