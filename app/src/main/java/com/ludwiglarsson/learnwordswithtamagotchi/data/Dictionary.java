package com.ludwiglarsson.learnwordswithtamagotchi.data;


public class Dictionary {

    public void words(DataBaseHandler dataBaseHandler) {
        //dataBaseHandler.deleteAll();
        //dataBaseHandler.addWord(new Words("Котик", "описание", "подсказки1/подсказки2/подсказки3/подсказки4/подсказки5","фото"), "animals");
        //dataBaseHandler.addWord(new Words("Каракатица", "описание", "подсказки1/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "animals");
        dataBaseHandler.addWord(new Words("Пизанская башня", "описание", "подсказки1/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "used");
        dataBaseHandler.addWord(new Words("Лувр", "описание", "подсказки1/подсказки2/подсказки3/подсказки4/Наибольшее количество спутников в Солнечной системе", "фото"), "used");
        //dataBaseHandler.addWord(new Words("Эйфелева башня", "описание", "подсказки1/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "used");
        //dataBaseHandler.addWord(new Words("Пизанская башня", "описание", "подсказки1/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "used");
        //dataBaseHandler.addWord(new Words("Кёльнский собор", "описание", "подсказки1/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "architecture");
        //dataBaseHandler.addWord(new Words("Собор Парижской Богоматери", "описание", "подсказки1/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "architecture");
    }
}
