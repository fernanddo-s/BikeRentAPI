<script setup>
import { onMounted, reactive } from 'vue';
import { create, update } from '@/services/BicicletaService'

const variaveis = reactive({
  dialog: false,
  bicicleta:{
    id: '',
    numero: '',
    marca: '',
    modelo: '',
    ano: '',
    status: ''
  },
  status:[
    'NOVA',
    'DISPONIVEL'
  ]
})

const props = defineProps({
  bicicleta:{
    id: Number,
    numero: Number,
    marca: String,
    modelo: String,
    ano: String,
    status: String
  },
  icon: '',
  editando: Boolean
})

async function save(id, bicicleta) {
  if(props.editando){
    update(id, bicicleta)
  }else{
    create(bicicleta);
  }
  variaveis.dialog = false
  limparForm()
}

function limparForm(){
  variaveis.bicicleta.marca = '';
  variaveis.bicicleta.modelo = '';
  variaveis.bicicleta.numero = 0;
  variaveis.bicicleta.status = '';
  variaveis.bicicleta.ano = '';
}

onMounted(async () => {
  if(props.editando){
    variaveis.bicicleta.marca = props.bicicleta.marca;
    variaveis.bicicleta.modelo = props.bicicleta.modelo;
    variaveis.bicicleta.numero = props.bicicleta.numero;
    variaveis.bicicleta.status = props.bicicleta.status;
    variaveis.bicicleta.ano = props.bicicleta.ano;
  }
})
</script>

<template>
  <div class="pa-4 text-center">
    <v-dialog
      v-model="variaveis.dialog"
      max-width="800"
    >
      <template v-slot:activator="{ props: activatorProps }">
        <v-icon
          class="mr-3 btn-actions" color="primary"
          v-bind="activatorProps"
        >{{ props.icon }}</v-icon>
      </template>

      <v-card title="Bicicleta Form">
        <v-card-text v-if="props.editando">
          <v-row>
            <v-col cols="12" md="6" sm="6">
              <v-text-field type="text" label="Número*" v-model="variaveis.bicicleta.numero"></v-text-field>
            </v-col>
            <v-col>
              <v-text-field type="text" label="Marca*" v-model="variaveis.bicicleta.marca"></v-text-field>
            </v-col>
            <v-col cols="12" md="6" sm="6">
              <v-text-field type="text" label="Modelo" v-model="variaveis.bicicleta.modelo" ></v-text-field>
            </v-col>
            <v-col >
              <v-select label="Status" v-model="variaveis.bicicleta.status" :items="variaveis.status"></v-select>
            </v-col>
            <v-col cols="12" md="6" sm="6">
              <v-text-field type="text" label="Ano" v-model="variaveis.bicicleta.ano" ></v-text-field>
            </v-col>
          </v-row>
          <small class="text-caption text-medium-emphasis">*indica campo obrigatório</small>
        </v-card-text>
        <v-card-text v-else>
            <v-row>
            <v-col cols="12" md="6" sm="6">
              <v-text-field type="text" label="Número*" v-model="variaveis.bicicleta.numero"></v-text-field>
            </v-col>
            <v-col>
              <v-text-field type="text" label="Marca*" v-model="variaveis.bicicleta.marca"></v-text-field>
            </v-col>
            <v-col cols="12" md="6" sm="6">
              <v-text-field type="text" label="Modelo" v-model="variaveis.bicicleta.modelo" ></v-text-field>
            </v-col>
            <v-col >
              <v-select label="Status" v-model="variaveis.bicicleta.status" :items="variaveis.status"></v-select>
            </v-col>
            <v-col cols="12" md="6" sm="6">
              <v-text-field type="text" label="Ano" v-model="variaveis.bicicleta.ano" ></v-text-field>
            </v-col>
          </v-row>
          <small class="text-caption text-medium-emphasis">*indica campo obrigatório</small>
        </v-card-text>

        <v-divider></v-divider>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn text="Cancelar" @click="variaveis.dialog = false"></v-btn>
          <v-btn color="primary" text="Salvar" @click="save(props.bicicleta.id, variaveis.bicicleta)"></v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>