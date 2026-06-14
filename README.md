# Втора домашна задача по Софтверско инженерство

Име и презиме: Erand Ibraimi
Број на индекс: 231525

---

## 1. Control Flow Graph

### CFG за `searchBookByTitle`

![CFG searchBookByTitle](images/searchBookByTitle.png)

### CFG за `borrowBook`

![CFG borrowBook](images/borrowbookCFG.png)

---

## 2. Цикломатска комплексност

Цикломатската комплексност ја пресметувам со формулата:

`V(G) = P + 1`

каде што `P` е бројот на предикатни јазли.

### `searchBookByTitle`

Предикатни јазли:

1. `title.isEmpty()`
2. `for (Book book : books)`
3. `book.getTitle().equalsIgnoreCase(title)`
4. `!book.isBorrowed()`
5. `results.isEmpty()`

`V(G) = 5 + 1 = 6`

Цикломатската комплексност е **6**.

### `borrowBook`

Предикатни јазли:

1. `title.isEmpty()`
2. `author.isEmpty()`
3. `for (Book book : books)`
4. `book.getTitle().equalsIgnoreCase(title)`
5. `book.getAuthor().equalsIgnoreCase(author)`
6. `!book.isBorrowed()`

`V(G) = 6 + 1 = 7`

Цикломатската комплексност е **7**.

---

## 3. Every Statement критериум за `searchBookByTitle`

Минимален број на тест случаи: **3**

| Тест | Опис                                            | Очекуван резултат                  |
| ---- | ----------------------------------------------- | ---------------------------------- |
| T1   | Се повикува `searchBookByTitle("")`             | Се фрла `IllegalArgumentException` |
| T2   | Се пребарува книга која постои и не е изнајмена | Се враќа листа со таа книга        |
| T3   | Се пребарува книга која не постои               | Се враќа `null`                    |

Со овие тестови се покриваат сите наредби во функцијата: проверката за празен наслов, креирањето на листата, циклусот, условот за совпаѓање, додавањето во резултати, проверката дали листата е празна, `return null` и `return results`.

---

## 4. Every Branch критериум за `borrowBook`

Минимален број на тест случаи: **5**

| Тест | Опис                                | Очекуван резултат                            |
| ---- | ----------------------------------- | -------------------------------------------- |
| T1   | Празен `title`                      | Се фрла `IllegalArgumentException`           |
| T2   | Празен `author`                     | Се фрла `IllegalArgumentException`           |
| T3   | Книгата постои и не е изнајмена     | Книгата се означува како изнајмена           |
| T4   | Книгата постои, но веќе е изнајмена | Се фрла `RuntimeException`                   |
| T5   | Нема книга со точен наслов и автор  | Се фрла `RuntimeException("Book not found")` |

Со овие тестови се покриваат сите гранки во функцијата `borrowBook`.

---

## 5. Multiple Condition критериум

### Услов во `borrowBook`

Услов:

```java
if (title.isEmpty() || author.isEmpty())
```

| Тест | `title.isEmpty()` | `author.isEmpty()` | Резултат |
| ---- | ----------------- | ------------------ | -------- |
| T1   | true              | true               | true     |
| T2   | true              | false              | true     |
| T3   | false             | true               | true     |
| T4   | false             | false              | false    |

Минимален број на тест случаи: **4**

---

### Услов во `searchBookByTitle`

Услов:

```java
if (book.getTitle().equalsIgnoreCase(title) && !book.isBorrowed())
```

| Тест | title matches | book is not borrowed | Резултат |
| ---- | ------------- | -------------------- | -------- |
| T1   | true          | true                 | true     |
| T2   | true          | false                | false    |
| T3   | false         | true                 | false    |
| T4   | false         | false                | false    |

Минимален број на тест случаи: **4**
