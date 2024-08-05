<template>
    
</template>

<script>
import backendService from '../Services/BackendService.js';

export default {
    data() {
        return {
            jobCards: [],
            isLoading: true
        };
    },
    created() {
        backendService.getAllJobCards().then(
            (response) => {
                this.jobCards = response.data;
                this.isLoading = false;
            }
        );
    }
}
</script>

<style scoped>
</style>