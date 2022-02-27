# borasertech-838-resumoPOO

Repo que tem como propósito realizar uma implementação que envolva a aplicação de todos os conceitos e técnicas vistas ao longo do módulo de Introdução à POO da turma 838.

## Herança vs Classe Abstrata vs Interface

### Herança

É um recurso da POO que permite que os atributos e métodos tenham suas implementações reaproveitadas, sem precisar reescrever código. A classe que fornece esses comportamentos é chamada de superclasse (também conhecida como "Classe Mãe" ou "Classe Pai") e a classe que herda essas implementações é chamada de Subclasse ou "Classe Filha".

#### Características da Herança

- É realizada utilizando a palavra reservada ```extends```, de modo que uma classe filha sempre vai estender de sua classe mãe.
  * Exemplo: se tivermos uma classe chamada Animal que é mãe de uma classe Mamífero, então a herança é expressa através da sentença abaixo
```java
public class Mamifero extends Animal
```
- Não podemos ter herança múltipla, ou seja, uma única classe filha não pode estender de duas classes de uma só vez, portanto ***não*** é possível declarar uma classe da maneira abaixo
```java 
public class Cachorro extends Mamifero, Animal
```
- Todos os métodos implementados na classe mãe terão o mesmo comportamento / lógica quando chamados pela classe filha, a não ser que seja aplicado o polimorfismo de sobrescrição (que é aquele que a assinatura do método não muda e cuja boa prática é utilizar a annotation ```@Override```).
- Caso o polimorfismo seja aplicado, passa a valer o comportamento implementado na classe filha.

#### Quando usar Herança?

Quando quero que uma classe reaproveite e herde os atributos e comportamentos implementados, de modo que eu não precise reescrever código. Mas fique sempre atento e aplique o princípio do ***"é um"*** para não usar esse recurso de forma inapropriada.

### Classe Abstrata

É uma categoria especial de classe mãe que não permite a instanciação de objetos dela própria, mas somente de sua(s) classe(s) filha(s).

#### Características de uma Classe Abstrata

- Ela possui as mesmas características de uma classe mãe "comum", definindo os atributos e métodos que os objetos devem implementar
  * A diferença é que é proibido instanciar objetos através desta classe mãe, e sim somente de sua(s) filha(s).
- Exemplo: considere a ```public abstract class Professor```, que tem como filhas as classes ```ProfessorTitular``` e ```ProfessorAuxiliar```. Eu ***não*** posso instanciar um objeto com a sintaxe abaixo
```java
Professor professor = new Professor();
```
- Mas é possível eu realizar à instância abaixo
```java
ProfessorTitular profTitular = new ProfessorTitular();
```
- Uma classe abstrata pode possuir também métodos abstratos. Quando isso acontece, a implementação do método deve ser realizada obrigatoriamente na(s) classe(s) filha(s). Para declarar um método abstrato, devemos incluir uma assinatura de método na qual iremos usar a palavra reservada ```abstract``` após a visibilidade do método, conforme:
```java
public abstract double calculaPerimetro();
```
- Além dos métodos abstratos, é possível incluir nas classes abstratas métodos com um corpo de implementação default, de modo que suas filhas consigam reaproveitá-los. 

#### Quando usar classes e métodos abstratos?

- Classe abstrata: se eu identificar que, por regra de negócio, eu não posso instanciar um objeto do tipo da classe mãe, mas quero me reaproveitar de comportamentos comuns codificando-os somente uma vez, posso me servir de uma classe abstrata.
  * Exemplo: considere uma concessionária de carros e motos. Eu posso criar as classes ```Carro``` e ```Moto``` sem herdar de ninguém. Porém, ao implementar ou ler a especificação, vejo que ambas têm características em comum (como fabricante, ano e modelo). Para não ficar duplicando essas implementações (ou até correr o risco de modificar uma classe e esquecer de modificar outra no futuro) eu posso criar uma classe ```Veiculo```, que centraliza essas características em comum. Porém, no meu contexto não faz sentido instanciar só um ```Veiculo```, preciso me servir também das características de ```Carro``` e ```Moto```, então nesse caso a implementação de uma classe abstrata é adequada.
- Método abstrato: quando eu preciso obrigar minhas classes filhas a implementar algum comportamento dado que não faz sentido realizar implementações default pois os comportamentos são muitos específicos e precisam ficar nas filhas.
  * Exemplo: no método desenho implementado em aula, não tem um animal default para eu desenhar, por regra eu tenho que implementar os desenhos de acordo com o tipo. Como eu também tenho atributos a herdar, nesse caso faz sentido me servir de um método abstrato em uma classe mãe.

### Interface

É um "contrato" estabelecido entre a a própria interface e quem se propõe a implementá-la, de modo que todos os métodos que estejam na interface sejam codificados na classe que está assinando esse contrato.

#### Características de uma Interface

- Uma interface é implementada através da sintaxe ```public interface IConta```, sendo que ```IConta``` é o nome da interface criada e é uma boa prática colocar um I maiúsculo como inicial, seguido do conceito de negócio que essa entidade representa.
- Não existem atributos em uma interface, no máximo podem existir constantes.
- Quando eu crio a assinatura do método na interface, não preciso deuxar a visibilidade como ```public```, pois por deafult todos os métodos assinados já estão com essa visibilidade, conforme exemplo:
```java
public interface IConta {
    boolean saca(double valor);
    boolean transfere(Conta destino, double valor);
    void deposita(double valor);
}
```
- Via de regra, uma interface ***não*** implementa os métodos contidos nela (portanto, eles não possuem "corpo"), essa implementação fica à cargo das classes que assinam o contrato com ela.
  * Uma exceção à regra é o uso de uma implementação ```default```.
- Uma classe implementa uma interface através da palavra reservada ```implements``` conforme:
```java
public class Conta implements IConta
```
- Neste caso, ao contrário da Herança, é possível que uma classe implemente várias interfaces diretamente, conforme exemplo abaixo:
```java
public class Conta implements IConta, ITarifas
```

#### Quando usar interfaces?

Quando eu preciso que os métodos tenham suas implementações específicas por todos que assinam essa interface. Como uma interface não tem atributos, ela é adequada para casos que não preciso herdar ou reaproveitar atributos, somente comportamentos. Além disso, se preciso implementar comportamentos de vários lugares (lembrando sempre, ***desde que faça sentido***), eu posso utilizar várias interfaces para servirem como contrato de implementação de minhas classes.

### Links e Referências 🤓

- https://www.geeksforgeeks.org/difference-between-abstract-class-and-interface-in-java/
- https://www.guru99.com/interface-vs-abstract-class-java.html
- https://www.devmedia.com.br/java-interface-aprenda-a-usar-corretamente/28798
- https://www.devmedia.com.br/polimorfismo-classes-abstratas-e-interfaces-fundamentos-da-poo-em-java/26387
- GRADY BOOCH, Robert Maksimchuk et al. Object-Oriented Analysis and Design with Applications. Chemistry & biodiversity, 2007.