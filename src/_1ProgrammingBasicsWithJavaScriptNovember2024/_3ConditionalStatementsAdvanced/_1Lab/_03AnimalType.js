function animalType(animalType) {
    let animalClass = "";

    if (animalType === "dog") {
        animalClass = "mammal";
    } else if (animalType === "crocodile") {
        animalClass = "reptile";
    } else if (animalType === "tortoise") {
        animalClass = "reptile";
    } else if (animalType === "snake") {
        animalClass = "reptile";
    } else {
        animalClass = "unknown";
    }

    console.log(`${animalClass}`)
}