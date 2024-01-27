import { fetchGetRequest } from "../api/requests"
import { APP_URL_LOGIN } from "../data/constants"
import { saveCredentials } from "./credentials"


export async function login(username, password){
    const credentials = { username, password}
    const response = await fetchGetRequest(APP_URL_LOGIN, credentials)
    const status = response.status
    if(status != 200) {
        return false
    }
    saveCredentials(credentials)
    return true
}