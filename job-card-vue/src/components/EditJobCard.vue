<template>
  <button class="edit-btn" v-if="showBtn" @click="showBtn=!showBtn">Edit</button>
  <button class="done-btn" v-if="!showBtn" @click="showBtn=!showBtn">Done</button>
</template>

<script>
import BackendService from '@/Services/BackendService';

export default {
    data() {
        return {
            showBtn: true
        }
    },
    methods: {
        editJobCard(jobCard) {
            BackendService.editJobCard(jobCard).then((response) => {
                if(response.status==200) {
                    alert("Job card has been updated.");
                    this.$router.go();
                }
            });
        }
    }

}
</script>

<style>

</style>