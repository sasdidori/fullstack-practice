const key = 'credentials'

export function saveCredentials(credentials) {
    localStorage.setItem(key, JSON.stringify(credentials))

}

export function getCredentials(){
    const credentialsString = localStorage.getItem(key)
    return credentialsString == null ? null : JSON.parse(credentialsString)
}

export function deleteCredentials(){
    localStorage.removeItem(key)
}