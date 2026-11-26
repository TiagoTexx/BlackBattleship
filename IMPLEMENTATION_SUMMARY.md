# Implementação do Padrão Page Object Model (POM) - UserStoryTest1

## 📋 Resumo da Implementação

Foi implementado o padrão **Page Object Model (POM)** para o cenário de teste **UserStoryTest1** contido no ficheiro `IstarIscte.side`.

---

## 🎯 Cenário de Teste (do IstarIscte.side)

### UserStoryTest1 - Fluxo Completo:

1. **Abrir navegador** → Navega para `https://istar.iscte-iul.pt`
2. **Definir tamanho da janela** → 1282x693
3. **Clicar menu "People"** → Acede à secção de colaboradores
4. **Selecionar José Reis** → Clica no 40º colaborador (José Vicente Pereira dos Reis)
5. **Ver Ensino e Orientações** → Clica na aba de ensino e orientações

**URL final esperada:** `https://istar.iscte-iul.pt/authors/jose-vicente-pereira-dos-reis/teaching`

---

## 📁 Estrutura de Ficheiros Criados

```
src/test/java/iscteiul/ista/blackbattleship/
├── UserStory1.java              ← Page Object Class
└── UserStoryTest1.java          ← Page Test Class
```

---

## 🏗️ Arquitetura POM Implementada

```
┌─────────────────────────────────────┐
│   UserStoryTest1 (Testes JUnit)     │
│  - Lógica de testes                 │
│  - Assertions (@Test)               │
│  - Ciclo de vida (@BeforeEach/@AfterEach)
└────────────────┬────────────────────┘
                 │
                 │ Utiliza métodos
                 │ de alto nível
                 │
┌────────────────▼────────────────────┐
│   UserStory1 (Page Object)          │
│  - @FindBy annotations              │
│  - navigateToPeople()               │
│  - selectJoseReis()                 │
│  - clickTeachingAndGuidanceTab()    │
│  - Métodos utilitários              │
└────────────────┬────────────────────┘
                 │
                 │ Interage com
                 │
┌────────────────▼────────────────────┐
│  Página Web (istar.iscte-iul.pt)   │
│  - Elementos HTML                   │
│  - Navegação                        │
└─────────────────────────────────────┘
```

---

## 📝 Classe 1: UserStory1.java (Page Object Class)

### Localização
`C:\Java\Idea-workspace\BlackBattleship\src\test\java\iscteiul\ista\blackbattleship\UserStory1.java`

### Elementos Localizados (@FindBy)

| Elemento | Localizador CSS/LinkText | Descrição |
|----------|-------------------------|-----------|
| **peopleMenuLink** | `#menu-item-51120 > .menu-item-link` | Menu "People" na navegação principal |
| **joseReisLink** | `#box-11 .mk-employee-item:nth-child(40) .team-member-name > .team-member-name` | Link para José Reis (40º colaborador) |
| **teachingAndGuidanceTab** | `linkText=Ensino e Orientações` | Aba de ensino e orientações |

### Métodos Principais

#### 1. `navigateToPeople()`
- **Descrição:** Navega para a secção de pessoas clicando no menu "People"
- **Parâmetros:** Nenhum
- **Retorno:** void
- **Espera:** Explicit wait (10 segundos) até elemento ser clicável

#### 2. `selectJoseReis()`
- **Descrição:** Seleciona José Reis da lista de colaboradores
- **Parâmetros:** Nenhum
- **Retorno:** void
- **Espera:** Explicit wait (10 segundos) até elemento ser clicável

#### 3. `clickTeachingAndGuidanceTab()`
- **Descrição:** Clica na aba "Ensino e Orientações"
- **Parâmetros:** Nenhum
- **Retorno:** void
- **Espera:** Explicit wait (10 segundos) até elemento ser clicável

#### 4. Métodos Utilitários
- `getPageTitle()` - Retorna o título da página
- `getCurrentUrl()` - Retorna a URL atual
- `waitForElementVisibility(By locator)` - Espera até elemento ficar visível
- `waitForElementPresence(By locator)` - Espera até elemento estar presente no DOM
- `getElement(By locator)` - Retorna um elemento específico

### Características Principais
✅ **Javadoc completo** em cada método e campo
✅ **Explicit waits** (10 segundos) para confiabilidade
✅ **Encapsulação** de todos os localizadores
✅ **PageFactory** para injeção de elementos
✅ **Tratamento de exceções** com mensagens descritivas

---

## 🧪 Classe 2: UserStoryTest1.java (Page Test Class)

### Localização
`C:\Java\Idea-workspace\BlackBattleship\src\test\java\iscteiul\ista\blackbattleship\UserStoryTest1.java`

### Métodos de Ciclo de Vida

#### `setUp()` - @BeforeEach
- Cria instância de ChromeDriver
- Maximiza janela do navegador
- Define implicit wait (10 segundos)
- Navega para URL base
- Inicializa Page Object

#### `tearDown()` - @AfterEach
- Fecha WebDriver
- Liberta recursos
- Garante isolamento entre testes

### Testes Implementados

#### 1. `testNavigateToPeopleMenu()`
- **DisplayName:** "Should navigate to People section by clicking menu"
- **O que testa:** Navegação para secção de pessoas
- **Assertions:** URL contém "people"

#### 2. `testSelectJoseReis()`
- **DisplayName:** "Should select José Reis and navigate to his profile"
- **O que testa:** Seleção de colaborador específico
- **Assertions:** URL muda e contém "authors"

#### 3. `testViewTeachingAndGuidanceTab()`
- **DisplayName:** "Should click Teaching and Guidance tab and display content"
- **O que testa:** Visualização de informação de ensino
- **Assertions:** Aba é visível e URL contém "teaching"

#### 4. `testCompleteUserStoryWorkflow()` ⭐ **TESTE PRINCIPAL**
- **DisplayName:** "Should complete full UserStoryTest1 workflow successfully"
- **O que testa:** Fluxo completo (Todas as 5 etapas do IstarIscte.side)
- **Assertions:** 
  - URL contains "people" (após passo 1)
  - URL contém "authors" (após passo 2)
  - URL contém "teaching" (após passo 3)
  - Conteúdo de ensino está presente

#### 5. `testUserStoryNavigationSequence()`
- **DisplayName:** "Should execute full navigation sequence without errors"
- **O que testa:** Execução sem exceções
- **Assertions:** `assertDoesNotThrow` para todas as ações

### Características Principais
✅ **JUnit 5 (Jupiter)** - Usando @Test, @BeforeEach, @AfterEach
✅ **@DisplayName** - Nomes descritivos para cada teste
✅ **Javadoc extensivo** - Documentação completa de cada teste
✅ **Assertions robustas** - Várias validações por teste
✅ **Utility methods** - `sleepThread()` para controlo de tempo

---

## 🔄 Comparação: IstarIscte.side vs Implementação POM

### IstarIscte.side (Teste Manual)
```
{
  "command": "open",          →  Feito no setUp()
  "command": "setWindowSize"  →  Feito no setUp()
  "command": "click",         →  navigateToPeople()
  "command": "click",         →  selectJoseReis()
  "command": "click"          →  clickTeachingAndGuidanceTab()
}
```

### Implementação POM
```java
@BeforeEach
public void setUp() {
    // open + setWindowSize
}

@Test
public void testCompleteUserStoryWorkflow() {
    userStory1.navigateToPeople();          // click People menu
    userStory1.selectJoseReis();            // click José Reis
    userStory1.clickTeachingAndGuidanceTab(); // click Ensino e Orientações
}
```

---

## ✅ Benefícios do Padrão POM Implementado

| Benefício | Implementação |
|-----------|--------------|
| **Manutenibilidade** | Se um seletor mudar, altera-se apenas em `UserStory1.java` |
| **Reutilização** | Métodos podem ser usados em múltiplos testes |
| **Legibilidade** | Nomes claros: `navigateToPeople()`, `selectJoseReis()` |
| **Escalabilidade** | Fácil adicionar novos cenários/testes |
| **Documentação** | Javadoc completo em cada classe e método |
| **Confiabilidade** | Explicit waits (10 segundos) em vez de esperas rígidas |
| **Isolamento** | Cada teste é independente (setUp/tearDown) |
| **Assertions** | Múltiplas validações por teste |

---

## 🚀 Como Executar os Testes

### Executar todos os testes
```bash
mvn clean test
```

### Executar apenas UserStoryTest1
```bash
mvn clean test -Dtest=UserStoryTest1
```

### Executar um teste específico
```bash
mvn clean test -Dtest=UserStoryTest1#testCompleteUserStoryWorkflow
```

### Com saída detalhada
```bash
mvn clean test -Dtest=UserStoryTest1 -X
```

---

## 📊 Status da Compilação

✅ **BUILD SUCCESS**

```
[INFO] Building BlackBattleship 1.0-SNAPSHOT
[INFO] BUILD SUCCESS
```

---

## 📚 Estrutura Final do Projeto

```
BlackBattleship/
├── src/test/java/iscteiul/ista/blackbattleship/
│   ├── MainPage.java                  (Existente - JetBrains)
│   ├── MainPageTest.java              (Existente - JetBrains)
│   ├── UserStory1.java                (✨ NOVO - POM Class)
│   ├── UserStory1Test.java            (✨ NOVO - Test Class)
│   ├── UserStory2.java                (✨ NOVO - POM Class)
│   └── UserStory2Test.java            (✨ NOVO - Test Class)
├── IstarIscte.side                    (Teste Selenium IDE)
├── pom.xml                            (Dependências Maven)
└── ...
```

---

## 🎓 Padrão Page Object Model (POM)

O **Page Object Model** é um padrão de design para automação de testes que:

1. **Encapsula elementos** - Cada página tem uma classe associada
2. **Abstrai interações** - Métodos representam ações do utilizador
3. **Centraliza seletores** - Todos os localizadores num único lugar
4. **Reduz duplicação** - Código reutilizável entre testes
5. **Melhora manutenção** - Mudanças de UI afetam apenas a classe POM

### Estrutura POM
```
TestClass                  UserStory1                   WebPage
├── @Test methods          ├── @FindBy                  ├── HTML Elements
├── Assertions             ├── Page methods             └── ...
└── Page Object ref        └── Utility methods
```

---

## 📋 Checklist de Conformidade

- ✅ Classe `UserStory1.java` criada com padrão POM
- ✅ Classe `UserStoryTest1.java` criada com testes JUnit
- ✅ Javadoc completo em ambas as classes
- ✅ Todos os localizadores CSS/XPath do IstarIscte.side implementados
- ✅ Explicit waits implementados (10 segundos)
- ✅ Testes isolados com setUp/tearDown
- ✅ Compilação bem-sucedida (BUILD SUCCESS)
- ✅ Padrão POM seguido corretamente
- ✅ Nomes descritivos e @DisplayName em testes
- ✅ Comentários Javadoc extensivos

---

**Desenvolvido pela equipa BlackBattleship**  
**Data:** Maio 2026  
**Versão:** 1.0

