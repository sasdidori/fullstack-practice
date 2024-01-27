import { Buffer } from "buffer"

export function fetchGetRequest(url, credentials) {
    const headers = new Headers()
    if(credentials != null) {
        const authorization = Buffer.from(credentials.username + ':' + credentials.password)
        headers.set('Authorization', 'Basic ' + authorization.toString('base64'))
    }
    return fetch(url, {headers: headers})
}

export function fetchPostRequest(url, credentials) {
    const headers = new Headers()
    headers.set("Content-Type", "application/json")
    if(credentials != null) {
        const authorization = Buffer.from(credentials.username + ':' + credentials.password)
        headers.set('Authorization', 'Basic ' + authorization.toString('base64'))
    }
    
    return fetch(url, 
        {headers: headers,
        method: "POST",
        })
}


const createAnime = (anime) => {
    return fetch('http://localhost:8080/animes', {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(anime)
    }).then((res) => res.json())
}