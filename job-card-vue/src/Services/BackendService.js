import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    getAllJobCards() {
        return http.get('/job-cards');
    },

    filterCardsByNum(num) {
        return http.get(`/job-cards-by-num/${num}`);
    },

    filterCardsByName(name) {
        return http.get(`/job-cards-by-name/${name}`);
    },

    addJobCard(card) {
        return http.post('/add-card', card);
    },

    deleteJobCard(id) {
        return http.delete(`job-cards/${id}`);
    },

    editJobCard(card) {
        return http.put('/job-cards', card);
    },

    getJobCardById(id) {
        return http.get(`/job-cards/${id}`);
    }
}