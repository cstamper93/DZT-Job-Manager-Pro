<template>

  <div class="job-number-container">
    <div class="existing-job-number" @mouseenter="jobNumberHover=true" 
    @mouseleave="jobNumberHover=false" v-if="!editJobNumber">
        <h1>Job Card # {{ jobCard.jobNumber }}</h1>
        <img class="headline-icon" v-if="jobNumberHover" src="../components/icons/edit.png" alt="Pencil Icon" @click="editJobNumber=true">
    </div>
    <div class="edit-job-number" v-if="editJobNumber">
        <h1>Job Card #</h1>
        <input class="input-box" type="Number" placeholder="Job Number" required autofocus v-model="jobCard.jobNumber"/>
        <button @click.prevent="editJobCard(this.jobCard)">Submit</button>
        <button @click="editJobNumber=false">Cancel</button>
    </div>
  </div>

    <div class="card-details-page">

        <h3 class="headline">Client Name: </h3>
        <div class="property-container" @mouseenter="lineHover=true, nameHover=true" 
        @mouseleave="lineHover=false, nameHover=false" v-if="!editName">
            <span v-if="jobCard.clientName!=null && jobCard.clientName.length!=0">{{ jobCard.clientName }}</span>
            <span v-else>N/A</span>
            <img v-if="nameHover" src="../components/icons/edit.png" alt="Pencil Icon" @click="editName=true">
        </div> 
        <div class="editLine" v-if="editName">
            <input class="input-box" type="text" placeholder="Name" required autofocus v-model="jobCard.clientName"/>
            <button @click.prevent="editJobCard(this.jobCard)">Submit</button>
            <button @click="editName=false">Cancel</button>
        </div>

        <h3 class="headline">Phone Number: </h3>
        <div class="property-container" @mouseenter="lineHover=true, phoneHover=true" 
        @mouseleave="lineHover=false, phoneHover=false" v-if="!editPhoneNumber">
            <span v-if="jobCard.phoneNumber!=null && jobCard.phoneNumber.length!=0">{{ jobCard.phoneNumber }}</span>
            <span v-else>N/A</span>
            <img v-if="phoneHover" src="../components/icons/edit.png" alt="Pencil Icon" @click="editPhoneNumber=true">
        </div>  
        <div class="editLine" v-if="editPhoneNumber">
            <input class="input-box" type="text" placeholder="Phone Number" required autofocus v-model="jobCard.phoneNumber"/>
            <button @click.prevent="editJobCard(this.jobCard)">Submit</button>
            <button @click="editPhoneNumber=false">Cancel</button>
        </div>

        <h3 class="headline">Alternate Phone Number: </h3>
        <div class="property-container" @mouseenter="lineHover=true, altPhoneHover=true" 
        @mouseleave="lineHover=false, altPhoneHover=false" v-if="!editAltPhone">
            <span v-if="jobCard.altPhoneNumber!=null && jobCard.altPhoneNumber.length!=0">{{ jobCard.altPhoneNumber }}</span>
            <span v-else>N/A</span>
            <img v-if="altPhoneHover" src="../components/icons/edit.png" alt="Pencil Icon" @click="editAltPhone=true">
        </div>    
        <div class="editLine" v-if="editAltPhone">
            <input class="input-box" type="text" placeholder="Alt Phone Number" required autofocus v-model="jobCard.altPhoneNumber"/>
            <button @click.prevent="editJobCard(this.jobCard)">Submit</button>
            <button @click="editAltPhone=false">Cancel</button>
        </div>

        <h3 class="headline">Client Email: </h3>
        <div class="property-container" @mouseenter="lineHover=true, emailHover=true" 
        @mouseleave="lineHover=false, emailHover=false" v-if="!editEmail">
            <span v-if="jobCard.clientEmail!=null && jobCard.clientEmail.length!=0">{{ jobCard.clientEmail }}</span>
            <span v-else>N/A</span>
            <img v-if="emailHover" src="../components/icons/edit.png" alt="Pencil Icon" @click="editEmail=true">
        </div>
        <div class="editLine" v-if="editEmail">
            <input class="input-box" type="text" placeholder="Email" required autofocus v-model="jobCard.clientEmail"/>
            <button @click.prevent="editJobCard(this.jobCard)">Submit</button>
            <button @click="editEmail=false">Cancel</button>
        </div>

        <h3 class="headline">Alternate Email: </h3>
        <div class="property-container" @mouseenter="lineHover=true, altEmailHover=true" 
        @mouseleave="lineHover=false, altEmailHover=false" v-if="!editAltEmail">
            <span v-if="jobCard.altEmail!=null && jobCard.altEmail.length!=0">{{ jobCard.altEmail }}</span>
            <span v-else>N/A</span>
            <img v-if="altEmailHover" src="../components/icons/edit.png" alt="Pencil Icon" @click="editAltEmail=true">
        </div>   
        <div class="editLine" v-if="editAltEmail">
            <input class="input-box" type="text" placeholder="Alternate Email" required autofocus v-model="jobCard.altEmail"/>
            <button @click.prevent="editJobCard(this.jobCard)">Submit</button>
            <button @click="editAltEmail=false">Cancel</button>
        </div> 

        <h3 class="headline">Job Address: </h3>
        <div class="property-container" @mouseenter="lineHover=true, addressHover=true" 
        @mouseleave="lineHover=false, addressHover=false" v-if="!editAddress">
            <span v-if="jobCard.jobAddress!=null && jobCard.jobAddress!=0">{{ jobCard.jobAddress }}</span>
            <span v-else>N/A</span>
            <img v-if="addressHover" src="../components/icons/edit.png" alt="Pencil Icon" @click="editAddress=true">
        </div>
        <div class="editLine" v-if="editAddress">
            <input class="input-box" type="text" placeholder="Address" required autofocus v-model="jobCard.jobAddress"/>
            <button @click.prevent="editJobCard(this.jobCard)">Submit</button>
            <button @click="editAddress=false">Cancel</button>
        </div> 

        <h3 class="headline">Job Type: </h3>
        <div class="property-container" @mouseenter="lineHover=true, typeHover=true" 
        @mouseleave="lineHover=false, typeHover=false" v-if="!editType">
            <span v-if="jobCard.jobType!=null && jobCard.jobType.length!=0">{{ jobCard.jobType }}</span>
            <span v-else>N/A</span>
            <img v-if="typeHover" src="../components/icons/edit.png" alt="Pencil Icon" @click="editType=true">
        </div>
        <div class="editLine" v-if="editType">
            <input class="input-box" type="text" placeholder="Job Type" required autofocus v-model="jobCard.jobType"/>
            <button @click.prevent="editJobCard(this.jobCard)">Submit</button>
            <button @click="editType=false">Cancel</button>
        </div> 

        <h3 class="headline">Status: </h3>
        <div class="property-container" @mouseenter="lineHover=true, statusHover=true" 
        @mouseleave="lineHover=false, statusHover=false" v-if="!editStatus">
            <span v-if="jobCard.jobStatus!=null && jobCard.jobStatus.length!=0">{{ jobCard.jobStatus }}</span>
            <span v-else>N/A</span>
            <img v-if="statusHover" src="../components/icons/edit.png" alt="Pencil Icon" @click="editStatus=true">
        </div>
        <div class="editLine" v-if="editStatus">
            <input class="input-box" type="text" placeholder="Job Status" required autofocus v-model="jobCard.jobStatus"/>
            <button @click.prevent="editJobCard(this.jobCard)">Submit</button>
            <button @click="editStatus=false">Cancel</button>
        </div> 

        <h3 class="headline">Complete By: </h3>
        <div class="property-container" @mouseenter="lineHover=true, dateHover=true" 
        @mouseleave="lineHover=false, dateHover=false" v-if="!editDate">
            <span v-if="jobCard.completeBy!=null">{{ jobCard.completeBy }}</span>
            <span v-else>N/A</span>
            <img v-if="dateHover" src="../components/icons/edit.png" alt="Pencil Icon" @click="editDate=true">
        </div>
        <div class="editLine" v-if="editDate">
            <input class="input-box" type="date" placeholder="Complete By Date" required autofocus v-model="jobCard.completeBy"/>
            <button @click.prevent="editJobCard(this.jobCard)">Submit</button>
            <button @click="editDate=false">Cancel</button>
        </div> 

    </div>
</template>

<script>
import BackendService from '../Services/BackendService.js'

export default {
    name: 'job-card-details',
    data() {
        return {
            jobCard: Object,

            lineHover: false,

            jobNumberHover: false,
            nameHover: false,
            phoneHover: false,
            altPhoneHover: false,
            emailHover: false,
            altEmailHover: false,
            addressHover: false,
            typeHover: false,
            statusHover: false,
            dateHover: false,

            editJobNumber: false,
            editName: false,
            editPhoneNumber: false,
            editAltPhone: false,
            editEmail: false,
            editAltEmail: false,
            editAddress: false,
            editType: false,
            editStatus: false,
            editDate: false
            
        }
    },
    created() {
        BackendService.getJobCardById(this.userChoice).then((response) => {
            if(response.status === 200) {
                this.jobCard = response.data;
            }
        })
    },
    computed: {
        userChoice() {
            try {
                const userChoice = localStorage.getItem('userChoice');
                return Number(userChoice);
            } catch(error) {
                console.error('Error retrieving job card: ', error);
                return null;
            }
        }
    },
    methods: {
        editJobCard(jobCard) {
            BackendService.editJobCard(jobCard).then((response) => {
                if(response.status === 200) {
                    alert(`Changes to job ${jobCard.jobNumber} have been saved.`);
                    this.$router.go();
                } else {
                    alert('A problem was encountered. Please try again.');
                }
            })
        }
    }

}
</script>

<style scoped>

    .job-number-container {
        text-align: center;
    }

    .existing-job-number {
        display: flex;
        align-items: center;
        /* justify-content: center; */
    }

    .headline-icon {
        margin-left: 3rem;
    }
    .card-details-page {
        display: grid;
        grid-template-columns: 1fr 1fr;
        gap: 20px;
        margin-bottom: 5rem;
    }

    .headline {
        font-weight: bold;
        text-align: right;
        margin-right: 0.5rem;
    }

    span {
        margin-left: 0.5rem;
        text-align: left;
    }

    h1 {
        text-align: center;
        margin-top: 1.5rem;
        margin-bottom: 1.5rem;
    }

    .property-container {
        display: flex;
        align-items: center;
        justify-content: space-between;
    }

    .property-container:hover {
        background-color: #f0ffff;
    }

    img {
        width: 1.25rem;
        height: 1.25rem;
    }

<<<<<<< HEAD
    footer {
        background-color: #f0ffff;
=======
    img:hover {
        width: 1.5rem;
        height: 1.5rem;
>>>>>>> origin
    }

</style>