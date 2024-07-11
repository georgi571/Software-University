function inventory(input) {
    const heroes = [];
    for (let inputElement of input) {
        const heroInformation = inputElement.toString().split(' / ');
        const heroItems = heroInformation[2].toString().split(', ');
        let hero = {
            name: heroInformation[0],
            level: Number(heroInformation[1]),
            items: heroItems,
        }
        heroes.push(hero);
    }
    heroes.sort((a,b) => a.level - b.level);
    for (let hero of heroes) {
        console.log(`Hero: ${hero.name}`);
        console.log(`level => ${hero.level}`);
        console.log(`items => ${hero.items.join(', ')}`);
    }
}