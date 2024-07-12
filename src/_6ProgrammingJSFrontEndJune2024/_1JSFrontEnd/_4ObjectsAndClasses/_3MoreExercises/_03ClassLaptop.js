class Laptop {
    info = {};
    isOn = false;
    quality;

    constructor(info, quality) {
        this.info = {
            producer: info.producer,
            age : Number(info.age),
            brand: info.brand,
        }
        this.quality = Number(quality);
    }

    turnOn() {
        this.isOn = true;
        this.quality--;
    }

    turnOff() {
        this.isOn = false;
        this.quality--;
    }

    showInfo() {
        return JSON.stringify(this.info);
    }

    get price() {
        return (800 - (this.info.age * 2) + (this.quality * 0.5));
    }
}

