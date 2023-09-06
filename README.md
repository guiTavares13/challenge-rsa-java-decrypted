# Desafio RSA – Criptografia Assimétrica com Java

![Badge](https://img.shields.io/badge/version-1.0.0-green)
![Badge](https://img.shields.io/badge/license-MIT-blue)

## Table of Contents

- [Introdução](#introdução)
- [Pré-requisitos](#prerequisitos)
- [Algoritmo](#algoritmo)
- [Equipe](#contribuições)

## Introdução

Este código é um exemplo de um programa Java que usa o protocolo de transporte UDP para receber uma mensagem cifrada e chaves necessárias para decifrar a mensagem.
O código utiliza o protocolo UDP e a classe DatagramSocket para comunicação entre cliente e servidor. 
A mensagem cifrada e as chaves são enviadas pelo cliente e, em seguida, decifradas pelo servidor. 
O resultado é a mensagem original antes da criptografia.


### Pré-requisitos

- IDE que mais goste
- JDK 17
- Git (opcional)


### Algoritmo

1. `int porta = 12500;`
   Define a porta que o servidor vai escutar.

2. `DatagramSocket socket = new DatagramSocket(porta);`
   Cria um novo socket UDP na porta especificada.

3. As próximas três partes (`byte[]`, `DatagramPacket` e `socket.receive()`) recebem, respectivamente, a mensagem cifrada, a chave `d` e a chave `n`. Elas fazem o seguinte:
   - Cria um array de bytes com um tamanho específico.
   - Cria um pacote vazio (DatagramPacket) com esse array de bytes como buffer.
   - Recebe o pacote enviado pelo cliente usando a função `socket.receive()`.

4. `BigInteger msgCifrada`, `BigInteger d`, e `BigInteger n` convertem os arrays de bytes recebidos em objetos `BigInteger`.

5. Imprime no console as informações recebidas: mensagem cifrada, chave `d` e chave `n`.

6. `String msgDecifrada = new String(new BigInteger(msgCifrada.toByteArray()).modPow(d, n).toByteArray());`
   Esta linha decifra a mensagem utilizando a fórmula matemática: (mensagem_cifrada ^ d) mod n.
   A mensagem_decifrada é convertida em um array de bytes e depois em uma string.

7. `System.out.println("Mensagem decifrada: " + msgDecifrada);`
   Imprime a mensagem decifrada no console.

8. `socket.close();`
   Fecha o socket, encerrando a conexão.


### Equipe

- Guilherme Tavares
- Roger Kenich
- Yago Jose
- Carlos Alexandre
- Felipe Kevin

Engenharia de Computação 10° Semestre
Disciplina: Tópicos Avançados em Redes de Computadores
Prof° Fabio Henrique Cabrini
