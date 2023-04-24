package com.dfedorino.rtasks.first_level;

public class Cyphers {
    /**
     * Секретное агентство «Super-Secret-no» решило для шифрования переписки своих сотрудников использовать
     * «метод бутерброда». Сначала буквы слова нумеруются в таком порядке: первая буква получает номер 1,
     * последняя буква - номер 2, вторая – номер 3, предпоследняя – номер 4, потом третья … и так для всех
     * букв (см. рисунок). Затем все буквы записываются в шифр в порядке своих номеров. В конец зашифрованного
     * слова добавляется знак «диез» (#), который  нельзя использовать в сообщениях.
     * Например, слово «sandwich» зашифруется в «shacnidw#».
     *
     * @param phrase - строка, которую нужно зашифровать
     * @return зашифрованная строка
     */
    public String encrypt(String phrase) {
        StringBuilder encrypted = new StringBuilder(phrase.length());
        int leftIndex = 0;
        int rightIndex = phrase.length() - 1;
        while (leftIndex < rightIndex) {
            encrypted.append(phrase.charAt(leftIndex++)).append(phrase.charAt(rightIndex--));
        }
        return encrypted.append("#").toString();
    }

    /**
     * К сожалению, программист «Super-Secret-no», написал только программу шифрования и уволился. И теперь
     * агенты не могут понять, что же они написали друг другу. Помогите им.
     * <p>
     * Входные данные
     * Вводится слово, зашифрованное методом бутерброда. Длина слова не превышает 20 букв.
     * <p>
     * Выходные данные
     * Выведите расшифрованное слово.
     *
     * @param encrypted - зашифрованная строка
     * @return расшифрованная строка
     */
    public String decrypt(String encrypted) {
        char[] decryptedChars = new char[encrypted.length() - 1];
        int leftHalfIndex = 0;
        int rightHalfIndex = decryptedChars.length - 1;
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            if (currChar == '#') break;
            if (i % 2 == 0) decryptedChars[leftHalfIndex++] = currChar;
            else decryptedChars[rightHalfIndex--] = currChar;
        }
        return new String(decryptedChars);
    }
}
