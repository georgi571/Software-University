function songs(input) {
    class Song {
        typeList;
        name;
        time;

        constructor(typeList, name, time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }
    }

    let songArray = [];
    for (let i = 1; i <= input[0]; i++) {
        const songInfo = input[i].toString().split('_');
        const currentSong = new Song(songInfo[0], songInfo[1], songInfo[2]);
        songArray.push(currentSong);
    }
    for (let songArrayElement of songArray) {
        if (songArrayElement.typeList === input[input.length - 1] || input[input.length-1] === 'all') {
            console.log(songArrayElement.name);
        }
    }
}