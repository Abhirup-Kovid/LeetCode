class TimeLimitedCache {
    constructor() {
        this.cache = new Map();
    }

    set(key, value, duration) {
        const now = Date.now();
        const exists = this.cache.has(key) && this.cache.get(key).expiry > now;

        // Overwrite value and expiry
        this.cache.set(key, {
            value: value,
            expiry: now + duration
        });

        return exists;
    }

    get(key) {
        const now = Date.now();
        if (this.cache.has(key)) {
            const entry = this.cache.get(key);
            if (entry.expiry > now) {
                return entry.value;
            } else {
                this.cache.delete(key); // cleanup expired key
            }
        }
        return -1;
    }

    count() {
        const now = Date.now();
        let activeCount = 0;
        for (const [key, entry] of this.cache.entries()) {
            if (entry.expiry > now) {
                activeCount++;
            } else {
                this.cache.delete(key); // cleanup expired key
            }
        }
        return activeCount;
    }
}
