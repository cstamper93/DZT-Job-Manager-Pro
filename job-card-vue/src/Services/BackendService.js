import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    getAllJobCards() {
        return http.get('/job-cards');
    }
}