package com.ludwiglarsson.learnwordswithtamagotchi.data;


public class Dictionary {

    public void words(DataBaseHandler dataBaseHandler) {
        dataBaseHandler.deleteAll();
        dataBaseHandler.addWord(new Words("Котик", "описание", "подсказки/подсказки/подсказки","фото"), "words");
        dataBaseHandler.addWord(new Words("Каракатица", "описание", "подсказки/подсказки/подсказки", "фото"), "words");
        dataBaseHandler.addWord(new Words("Пизанская башня", "описание", "подсказки/подсказки/подсказки", "фото"), "architecture");
        dataBaseHandler.addWord(new Words("Лувр", "описание", "подсказки/подсказки/подсказки", "фото"), "used");
        dataBaseHandler.addWord(new Words("Эйфелева башня", "описание", "подсказки/подсказки/подсказки", "фото"), "used");
        dataBaseHandler.addWord(new Words("Пизанская башня", "описание", "подсказки/подсказки/подсказки", "фото"), "used");
        dataBaseHandler.addWord(new Words("Кёльнский собор", "описание", "подсказки/подсказки/подсказки", "фото"), "architecture");
        dataBaseHandler.addWord(new Words("Собор Парижской Богоматери", "описание", "подсказки/подсказки/подсказки", "фото"), "architecture");
    }
}
