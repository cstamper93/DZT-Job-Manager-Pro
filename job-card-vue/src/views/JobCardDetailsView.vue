<template>
    <JobCardDetails v-if="!editcard" />
    <EditJobCard v-if="editCard" />
</template>

<script>
import JobCardDetails from '../components/JobCardDetails.vue'
import EditJobCard from '../components/EditJobCard.vue'

export default {
    name: 'job-card-details-view',
    components: { 
        EditJobCard,
        JobCardDetails
    },
    data() {
        return {
            editCard: false
        }
    }
    
}
</script>

<style>

</style>