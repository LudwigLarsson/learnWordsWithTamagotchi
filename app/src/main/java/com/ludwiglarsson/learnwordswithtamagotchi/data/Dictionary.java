package com.ludwiglarsson.learnwordswithtamagotchi.data;


public class Dictionary {

    public void words(DataBaseHandler dataBaseHandler) {
        dataBaseHandler.deleteAll();
        dataBaseHandler.addWord(new Words("Котик", "описание", "котик/подсказки2/подсказки3/подсказки4/подсказки5","фото"), "animals");
        dataBaseHandler.addWord(new Words("Каракатица", "описание", "каракатица/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "animals");
        dataBaseHandler.addWord(new Words("Лось", "описание", "лось/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "animals");
        dataBaseHandler.addWord(new Words("Медуза", "описание", "медуза/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "animals");
        dataBaseHandler.addWord(new Words("Киви", "описание", "киви/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "animals");
        //dataBaseHandler.addWord(new Words("Пизанская башня", "пизанская башня", "подсказки1/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "used");
        dataBaseHandler.addWord(new Words("Лувр", "описание", "лувр/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "architecture");
        dataBaseHandler.addWord(new Words("Эйфелева башня", "эйфелева башня", "подсказки1/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "architecture");
        //dataBaseHandler.addWord(new Words("Пизанская башня", "описание", "подсказки1/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "used");
        dataBaseHandler.addWord(new Words("Кёльнский собор", "описание", "кёльнский собор/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "architecture");
        dataBaseHandler.addWord(new Words("Собор Парижской Богоматери", "описание", "собор парижской богоматери/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "architecture");
        dataBaseHandler.addWord(new Words("Агроном", "описание", "агроном/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "professions");
        dataBaseHandler.addWord(new Words("Дегустатор кошачьих кормов", "описание", "дегустатор кошачьих кормов/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "professions");
        dataBaseHandler.addWord(new Words("Самолёт", "описание", "самолёт/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "inventions");
        dataBaseHandler.addWord(new Words("Батискаф", "описание", "батискаф/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "inventions");
        dataBaseHandler.addWord(new Words("Секвойя", "описание", "секвойя/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "plants");
        dataBaseHandler.addWord(new Words("Шелковица", "описание", "шелковица/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "plants");
        dataBaseHandler.addWord(new Words("Сатурн", "описание", "сатурн/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "space");
        dataBaseHandler.addWord(new Words("Чёрная дыра", "описание", "чёрная дыра/подсказки2/подсказки3/подсказки4/подсказки5", "фото"), "space");
    }
}
