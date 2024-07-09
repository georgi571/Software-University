function cats(input) {
    class Cat {
        name;
        age;

        constructor(name, age) {
            this.name = name;
            this.age = age;
        }

        meow() {
            console.log(`${this.name}, age ${this.age} says Meow`);
        }
    }

    let catsArray = [];
    for (let inputElement of input) {
        const catInfo = inputElement.toString().split(' ');
        const currentCat = new Cat(catInfo[0], catInfo[1]);
        catsArray.push(currentCat);
    }
    for (let catsArrayElement of catsArray) {
        catsArrayElement.meow();
    }
}