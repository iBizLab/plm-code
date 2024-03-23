"use strict";
var pt = {
  Seconds: {
    name: "Segundos",
    every: "A cada segundo",
    interval: ["A cada", "segundo(s) come\xE7ando no segundo"],
    specific: "Segundo espec\xEDfico (escolha um ou muitos)",
    cycle: ["A Cada segundo entre segundos", "e segundo"]
  },
  Minutes: {
    name: "Minutos",
    every: "A cada minuto",
    interval: ["A cada", "minuto(s) come\xE7ando no minuto"],
    specific: "Minuto espec\xEDfico (escolha um ou muitos)",
    cycle: ["A cada minuto entre minutos", "e minutos"]
  },
  Hours: {
    name: "Horas",
    every: "A cada hora",
    interval: ["A cada", "hora(s) come\xE7ando na hora"],
    specific: "Hora espec\xEDfica (escolha uma ou muitas)",
    cycle: ["A cada hora entre horas", "e horas"]
  },
  Day: {
    name: "Dia",
    every: "A cada dia",
    intervalWeek: ["A cada", "dia(s) come\xE7ando em"],
    intervalDay: ["A cada", "dia(s) come\xE7ando no", "do m\xEAs"],
    specificWeek: "Dia espec\xEDfico da semana (escolha um ou v\xE1rios)",
    specificDay: "Dia espec\xEDfico do m\xEAs (escolha um ou v\xE1rios)",
    lastDay: "No \xFAltimo dia do m\xEAs",
    lastWeekday: "No \xFAltimo dia da semana do m\xEAs",
    lastWeek: ["No \xFAltimo", " do m\xEAs"],
    beforeEndMonth: ["dia(s) antes do final do m\xEAs"],
    nearestWeekday: [
      "Dia da semana mais pr\xF3ximo (segunda a sexta) ao ",
      "do m\xEAs"
    ],
    someWeekday: ["No", "do m\xEAs"]
  },
  Week: [
    "Domingo",
    "Segunda-feira",
    "Ter\xE7a-feira",
    "Quarta-feira",
    "Quinta-feira",
    "Sexta-feira",
    "S\xE1bado"
  ],
  Month: {
    name: "M\xEAs",
    every: "A cada m\xEAs",
    interval: ["A cada", "m\xEAs(es) come\xE7ando em"],
    specific: "M\xEAs espec\xEDfico (escolha um ou muitos)",
    cycle: ["Todo m\xEAs entre", "e"]
  },
  Year: {
    name: "Ano",
    every: "Qualquer ano",
    interval: ["A cada", "ano(s) come\xE7ando em"],
    specific: "Ano espec\xEDfico (escolha um ou muitos)",
    cycle: ["Todo ano entre", "e"]
  },
  Save: "Salvar",
  Close: "Fechar"
};

export { pt as default };
