<template>
  <div class="no-vue3-cron-div">
    <el-button
      class="language"
      type="text"
      @click="state.language = state.language === 'en' ? 'cn' : 'en'"
      >{{ state.language === 'en' ? 'cn' : 'en' }}</el-button
    >
    <el-tabs type="border-card">
      <el-tab-pane>
        <template #label>
          <span
            ><i class="el-icon-date"></i> {{ state.text.Seconds.name }}</span
          >
        </template>
        <div class="tabBody myScroller" :style="{ 'max-height': maxHeight }">
          <el-row>
            <el-radio v-model="state.second.cronEvery" label="1"
              >{{ state.text.Seconds.every }}
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.second.cronEvery" label="2"
              >{{ state.text.Seconds.interval[0] }}
              <el-input-number
                v-model="state.second.incrementIncrement"
                :min="1"
                :max="60"
              ></el-input-number>
              {{ state.text.Seconds.interval[1] || '' }}
              <el-input-number
                v-model="state.second.incrementStart"
                :min="0"
                :max="59"
              ></el-input-number>
              {{ state.text.Seconds.interval[2] || '' }}
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.second.cronEvery" class="long" label="3"
              >{{ state.text.Seconds.specific }}
              <el-select
                v-model="state.second.specificSpecific"
                multiple
                @click.stop.prevent
              >
                <el-option
                  v-for="(val, index) in 60"
                  :key="index"
                  :value="val - 1"
                  >{{ val - 1 }}
                </el-option>
              </el-select>
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.second.cronEvery" label="4"
              >{{ state.text.Seconds.cycle[0] }}
              <el-input-number
                v-model="state.second.rangeStart"
                :min="1"
                :max="60"
              ></el-input-number>
              {{ state.text.Seconds.cycle[1] || '' }}
              <el-input-number
                v-model="state.second.rangeEnd"
                :min="0"
                :max="59"
              ></el-input-number>
              {{ state.text.Seconds.cycle[2] || '' }}
            </el-radio>
          </el-row>
        </div>
      </el-tab-pane>
      <el-tab-pane>
        <template #label>
          <span
            ><i class="el-icon-date"></i> {{ state.text.Minutes.name }}</span
          >
        </template>
        <div class="tabBody myScroller" :style="{ 'max-height': maxHeight }">
          <el-row>
            <el-radio v-model="state.minute.cronEvery" label="1"
              >{{ state.text.Minutes.every }}
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.minute.cronEvery" label="2"
              >{{ state.text.Minutes.interval[0] }}
              <el-input-number
                v-model="state.minute.incrementIncrement"
                :min="1"
                :max="60"
              ></el-input-number>
              {{ state.text.Minutes.interval[1] }}
              <el-input-number
                v-model="state.minute.incrementStart"
                :min="0"
                :max="59"
              ></el-input-number>
              {{ state.text.Minutes.interval[2] || '' }}
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.minute.cronEvery" class="long" label="3"
              >{{ state.text.Minutes.specific }}
              <el-select
                v-model="state.minute.specificSpecific"
                multiple
                @click.stop.prevent
              >
                <el-option
                  v-for="(val, index) in 60"
                  :key="index"
                  :value="val - 1"
                  >{{ val - 1 }}
                </el-option>
              </el-select>
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.minute.cronEvery" label="4"
              >{{ state.text.Minutes.cycle[0] }}
              <el-input-number
                v-model="state.minute.rangeStart"
                :min="1"
                :max="60"
              ></el-input-number>
              {{ state.text.Minutes.cycle[1] }}
              <el-input-number
                v-model="state.minute.rangeEnd"
                :min="0"
                :max="59"
              ></el-input-number>
              {{ state.text.Minutes.cycle[2] }}
            </el-radio>
          </el-row>
        </div>
      </el-tab-pane>
      <el-tab-pane>
        <template #label>
          <span><i class="el-icon-date"></i> {{ state.text.Hours.name }}</span>
        </template>
        <div class="tabBody myScroller" :style="{ 'max-height': maxHeight }">
          <el-row>
            <el-radio v-model="state.hour.cronEvery" label="1"
              >{{ state.text.Hours.every }}
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.hour.cronEvery" label="2"
              >{{ state.text.Hours.interval[0] }}
              <el-input-number
                v-model="state.hour.incrementIncrement"
                :min="0"
                :max="23"
              ></el-input-number>
              {{ state.text.Hours.interval[1] }}
              <el-input-number
                v-model="state.hour.incrementStart"
                :min="0"
                :max="23"
              ></el-input-number>
              {{ state.text.Hours.interval[2] }}
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.hour.cronEvery" class="long" label="3"
              >{{ state.text.Hours.specific }}
              <el-select
                v-model="state.hour.specificSpecific"
                multiple
                @click.stop.prevent
              >
                <el-option
                  v-for="(val, index) in 24"
                  :key="index"
                  :value="val - 1"
                  >{{ val - 1 }}
                </el-option>
              </el-select>
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.hour.cronEvery" label="4"
              >{{ state.text.Hours.cycle[0] }}
              <el-input-number
                v-model="state.hour.rangeStart"
                :min="0"
                :max="23"
              ></el-input-number>
              {{ state.text.Hours.cycle[1] }}
              <el-input-number
                v-model="state.hour.rangeEnd"
                :min="0"
                :max="23"
              ></el-input-number>
              {{ state.text.Hours.cycle[2] }}
            </el-radio>
          </el-row>
        </div>
      </el-tab-pane>
      <el-tab-pane>
        <template #label>
          <span><i class="el-icon-date"></i> {{ state.text.Day.name }}</span>
        </template>
        <div class="tabBody myScroller" :style="{ 'max-height': maxHeight }">
          <el-row>
            <el-radio v-model="state.day.cronEvery" label="1"
              >{{ state.text.Day.every }}
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.day.cronEvery" label="2"
              >{{ state.text.Day.intervalWeek[0] }}
              <el-input-number
                v-model="state.week.incrementIncrement"
                :min="1"
                :max="7"
              ></el-input-number>
              {{ state.text.Day.intervalWeek[1] }}
              <el-select
                v-model="state.week.incrementStart"
                @click.stop.prevent
              >
                <el-option
                  v-for="(val, index) in 7"
                  :key="index"
                  :label="state.text.Week[val - 1]"
                  :value="val"
                ></el-option>
              </el-select>
              {{ state.text.Day.intervalWeek[2] }}
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.day.cronEvery" label="3"
              >{{ state.text.Day.intervalDay[0] }}
              <el-input-number
                v-model="state.day.incrementIncrement"
                :min="1"
                :max="31"
              ></el-input-number>
              {{ state.text.Day.intervalDay[1] }}
              <el-input-number
                v-model="state.day.incrementStart"
                :min="1"
                :max="31"
              ></el-input-number>
              {{ state.text.Day.intervalDay[2] }}
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.day.cronEvery" class="long" label="4"
              >{{ state.text.Day.specificWeek }}
              <el-select
                v-model="state.week.specificSpecific"
                multiple
                @click.stop.prevent
              >
                <el-option
                  v-for="(val, index) in 7"
                  :key="index"
                  :label="state.text.Week[val - 1]"
                  :value="
                    ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT'][val - 1]
                  "
                ></el-option>
              </el-select>
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.day.cronEvery" class="long" label="5"
              >{{ state.text.Day.specificDay }}
              <el-select
                v-model="state.day.specificSpecific"
                multiple
                @click.stop.prevent
              >
                <el-option v-for="(val, index) in 31" :key="index" :value="val"
                  >{{ val }}
                </el-option>
              </el-select>
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.day.cronEvery" label="6"
              >{{ state.text.Day.lastDay }}
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.day.cronEvery" label="7"
              >{{ state.text.Day.lastWeekday }}
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.day.cronEvery" label="8"
              >{{ state.text.Day.lastWeek[0] }}
              <el-select
                v-model="state.week.cronLastSpecificDomDay"
                @click.stop.prevent
              >
                <el-option
                  v-for="(val, index) in 7"
                  :key="index"
                  :label="state.text.Week[val - 1]"
                  :value="val"
                ></el-option>
              </el-select>
              {{ state.text.Day.lastWeek[1] || '' }}
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.day.cronEvery" label="9">
              <el-input-number
                v-model="state.day.cronDaysBeforeEomMinus"
                :min="1"
                :max="31"
              ></el-input-number>
              {{ state.text.Day.beforeEndMonth[0] }}
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.day.cronEvery" label="10"
              >{{ state.text.Day.nearestWeekday[0] }}
              <el-input-number
                v-model="state.day.cronDaysNearestWeekday"
                :min="1"
                :max="31"
              ></el-input-number>
              {{ state.text.Day.nearestWeekday[1] }}
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.day.cronEvery" label="11"
              >{{ state.text.Day.someWeekday[0] }}
              <el-input-number
                v-model="state.week.cronNthDayNth"
                :min="1"
                :max="5"
              ></el-input-number>
              <el-select
                v-model="state.week.cronNthDayDay"
                class="someWeekdaySelect"
                @click.stop.prevent
              >
                <el-option
                  v-for="(val, index) in 7"
                  :key="index"
                  :label="state.text.Week[val - 1]"
                  :value="val"
                ></el-option>
              </el-select>
              {{ state.text.Day.someWeekday[1] }}
            </el-radio>
          </el-row>
        </div>
      </el-tab-pane>
      <el-tab-pane>
        <template #label>
          <span><i class="el-icon-date"></i> {{ state.text.Month.name }}</span>
        </template>
        <div class="tabBody myScroller" :style="{ 'max-height': maxHeight }">
          <el-row>
            <el-radio v-model="state.month.cronEvery" label="1"
              >{{ state.text.Month.every }}
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.month.cronEvery" label="2"
              >{{ state.text.Month.interval[0] }}
              <el-input-number
                v-model="state.month.incrementIncrement"
                :min="0"
                :max="12"
              ></el-input-number>
              {{ state.text.Month.interval[1] }}
              <el-input-number
                v-model="state.month.incrementStart"
                :min="0"
                :max="12"
              ></el-input-number>
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.month.cronEvery" class="long" label="3"
              >{{ state.text.Month.specific }}
              <el-select
                v-model="state.month.specificSpecific"
                multiple
                @click.stop.prevent
              >
                <el-option
                  v-for="(val, index) in 12"
                  :key="index"
                  :label="val"
                  :value="val"
                ></el-option>
              </el-select>
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.month.cronEvery" label="4"
              >{{ state.text.Month.cycle[0] }}
              <el-input-number
                v-model="state.month.rangeStart"
                :min="1"
                :max="12"
              ></el-input-number>
              {{ state.text.Month.cycle[1] }}
              <el-input-number
                v-model="state.month.rangeEnd"
                :min="1"
                :max="12"
              ></el-input-number>
            </el-radio>
          </el-row>
        </div>
      </el-tab-pane>
      <el-tab-pane>
        <template #label>
          <span><i class="el-icon-date"></i> {{ state.text.Year.name }}</span>
        </template>
        <div class="tabBody myScroller" :style="{ 'max-height': maxHeight }">
          <el-row>
            <el-radio v-model="state.year.cronEvery" label="1"
              >{{ state.text.Year.every }}
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.year.cronEvery" label="2"
              >{{ state.text.Year.interval[0] }}
              <el-input-number
                v-model="state.year.incrementIncrement"
                :min="1"
                :max="99"
              ></el-input-number>
              {{ state.text.Year.interval[1] }}
              <el-input-number
                v-model="state.year.incrementStart"
                :min="2018"
                :max="2118"
              ></el-input-number>
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.year.cronEvery" class="long" label="3"
              >{{ state.text.Year.specific }}
              <el-select
                v-model="state.year.specificSpecific"
                filterable
                multiple
                @click.stop.prevent
              >
                <el-option
                  v-for="(val, index) in 100"
                  :key="index"
                  :label="2017 + val"
                  :value="2017 + val"
                ></el-option>
              </el-select>
            </el-radio>
          </el-row>
          <el-row>
            <el-radio v-model="state.year.cronEvery" label="4"
              >{{ state.text.Year.cycle[0] }}
              <el-input-number
                v-model="state.year.rangeStart"
                :min="2018"
                :max="2118"
              ></el-input-number>
              {{ state.text.Year.cycle[1] }}
              <el-input-number
                v-model="state.year.rangeEnd"
                :min="2018"
                :max="2118"
              ></el-input-number>
            </el-radio>
          </el-row>
        </div>
      </el-tab-pane>
    </el-tabs>
    <div class="bottom">
      <div class="value">
        <span> cron预览: </span>
        <el-tag type="primary">
          {{ state.cron }}
        </el-tag>
      </div>
      <div class="buttonDiv">
        <el-button type="primary" size="mini" @click.stop="handleChange">{{
          state.text.Save
        }}</el-button>
        <el-button type="primary" size="mini" @click="close">{{
          state.text.Close
        }}</el-button>
      </div>
    </div>
  </div>
</template>
<script>
import { watch, reactive, computed, toRefs, defineComponent } from 'vue';
import Language from './language';

export default defineComponent({
  name: 'NoVue3Cron',
  props: {
    cronValue: String,
    // eslint-disable-next-line vue/require-prop-types
    i18n: {},
    // eslint-disable-next-line vue/require-prop-types
    maxHeight: {},
  },
  setup(props, { emit }) {
    const { i18n } = toRefs(props);
    const state = reactive({
      language: i18n.value,
      second: {
        cronEvery: '1',
        incrementStart: 3,
        incrementIncrement: 5,
        rangeStart: 0,
        rangeEnd: 0,
        specificSpecific: [],
      },
      minute: {
        cronEvery: '1',
        incrementStart: 3,
        incrementIncrement: 5,
        rangeStart: 0,
        rangeEnd: 0,
        specificSpecific: [],
      },
      hour: {
        cronEvery: '1',
        incrementStart: 3,
        incrementIncrement: 5,
        rangeStart: 0,
        rangeEnd: 0,
        specificSpecific: [],
      },
      day: {
        cronEvery: '1',
        incrementStart: 1,
        incrementIncrement: 1,
        rangeStart: 0,
        rangeEnd: 0,
        specificSpecific: [],
        cronDaysBeforeEomMinus: 0,
        cronDaysNearestWeekday: 0,
      },
      week: {
        cronEvery: '1',
        incrementStart: 1,
        incrementIncrement: 1,
        specificSpecific: [],
        cronLastSpecificDomDay: 1,
        cronNthDayDay: 1,
        cronNthDayNth: 1,
      },
      month: {
        cronEvery: '1',
        incrementStart: 3,
        incrementIncrement: 5,
        rangeStart: 0,
        rangeEnd: 0,
        specificSpecific: [],
      },
      year: {
        cronEvery: '1',
        incrementStart: 2017,
        incrementIncrement: 1,
        rangeStart: 0,
        rangeEnd: 0,
        specificSpecific: [],
      },
      output: {
        second: '',
        minute: '',
        hour: '',
        day: '',
        month: '',
        Week: '',
        year: '',
      },
      text: computed(() => Language[state.language || 'cn']),
      secondsText: computed(() => {
        let seconds = '';
        const cronEvery = state.second.cronEvery;
        // eslint-disable-next-line default-case
        switch (cronEvery.toString()) {
          case '1':
            seconds = '*';
            break;
          case '2':
            seconds = `${state.second.incrementStart}/${state.second.incrementIncrement}`;
            break;
          case '3':
            // eslint-disable-next-line array-callback-return
            state.second.specificSpecific.map(val => {
              seconds += `${val},`;
            });
            seconds = seconds.slice(0, -1);
            break;
          case '4':
            seconds = `${state.second.rangeStart}-${state.second.rangeEnd}`;
            break;
        }
        return seconds;
      }),
      minutesText: computed(() => {
        let minutes = '';
        const cronEvery = state.minute.cronEvery;
        // eslint-disable-next-line default-case
        switch (cronEvery.toString()) {
          case '1':
            minutes = '*';
            break;
          case '2':
            minutes = `${state.minute.incrementStart}/${state.minute.incrementIncrement}`;
            break;
          case '3':
            // eslint-disable-next-line array-callback-return
            state.minute.specificSpecific.map(val => {
              minutes += `${val},`;
            });
            minutes = minutes.slice(0, -1);
            break;
          case '4':
            minutes = `${state.minute.rangeStart}-${state.minute.rangeEnd}`;
            break;
        }
        return minutes;
      }),
      hoursText: computed(() => {
        let hours = '';
        const cronEvery = state.hour.cronEvery;
        // eslint-disable-next-line default-case
        switch (cronEvery.toString()) {
          case '1':
            hours = '*';
            break;
          case '2':
            hours = `${state.hour.incrementStart}/${state.hour.incrementIncrement}`;
            break;
          case '3':
            // eslint-disable-next-line array-callback-return
            state.hour.specificSpecific.map(val => {
              hours += `${val},`;
            });
            hours = hours.slice(0, -1);
            break;
          case '4':
            hours = `${state.hour.rangeStart}-${state.hour.rangeEnd}`;
            break;
        }
        return hours;
      }),
      daysText: computed(() => {
        let days = '';
        const cronEvery = state.day.cronEvery;
        // eslint-disable-next-line default-case
        switch (cronEvery.toString()) {
          case '1':
            break;
          case '2':
          case '4':
          case '11':
          case '8':
            days = '?';
            break;
          case '3':
            days = `${state.day.incrementStart}/${state.day.incrementIncrement}`;
            break;
          case '5':
            // eslint-disable-next-line array-callback-return
            state.day.specificSpecific.map(val => {
              days += `${val},`;
            });
            days = days.slice(0, -1);
            break;
          case '6':
            days = 'L';
            break;
          case '7':
            days = 'LW';
            break;
          case '9':
            days = `L-${state.day.cronDaysBeforeEomMinus}`;
            break;
          case '10':
            days = `${state.day.cronDaysNearestWeekday}W`;
            break;
        }
        return days;
      }),
      weeksText: computed(() => {
        let weeks = '';
        const cronEvery = state.day.cronEvery;
        // eslint-disable-next-line default-case
        switch (cronEvery.toString()) {
          case '1':
          case '3':
          case '5':
            weeks = '?';
            break;
          case '2':
            weeks = `${state.week.incrementStart}/${state.week.incrementIncrement}`;
            break;
          case '4':
            // eslint-disable-next-line array-callback-return
            state.week.specificSpecific.map(val => {
              weeks += `${val},`;
            });
            weeks = weeks.slice(0, -1);
            break;
          case '6':
          case '7':
          case '9':
          case '10':
            weeks = '?';
            break;
          case '8':
            weeks = `${state.week.cronLastSpecificDomDay}L`;
            break;
          case '11':
            weeks = `${state.week.cronNthDayDay}#${state.week.cronNthDayNth}`;
            break;
        }
        return weeks;
      }),
      monthsText: computed(() => {
        let months = '';
        const cronEvery = state.month.cronEvery;
        // eslint-disable-next-line default-case
        switch (cronEvery.toString()) {
          case '1':
            months = '*';
            break;
          case '2':
            months = `${state.month.incrementStart}/${state.month.incrementIncrement}`;
            break;
          case '3':
            // eslint-disable-next-line array-callback-return
            state.month.specificSpecific.map(val => {
              months += `${val},`;
            });
            months = months.slice(0, -1);
            break;
          case '4':
            months = `${state.month.rangeStart}-${state.month.rangeEnd}`;
            break;
        }
        return months;
      }),
      yearsText: computed(() => {
        let years = '';
        const cronEvery = state.year.cronEvery;
        // eslint-disable-next-line default-case
        switch (cronEvery.toString()) {
          case '1':
            years = '*';
            break;
          case '2':
            years = `${state.year.incrementStart}/${state.year.incrementIncrement}`;
            break;
          case '3':
            // eslint-disable-next-line array-callback-return
            state.year.specificSpecific.map(val => {
              years += `${val},`;
            });
            years = years.slice(0, -1);
            break;
          case '4':
            years = `${state.year.rangeStart}-${state.year.rangeEnd}`;
            break;
        }
        return years;
      }),
      cron: computed(() => {
        return `${state.secondsText || '*'} ${state.minutesText || '*'} ${
          state.hoursText || '*'
        } ${state.daysText || '*'} ${state.monthsText || '*'} ${
          state.weeksText || '?'
        } ${state.yearsText || '*'}`;
      }),
    });
    watch(
      () => props.cronValue,
      newCron => {
        if (typeof newCron !== 'string' || !newCron) return false;
        const crons = newCron.split(' ');
        // 解析seconds
        const secondsText = crons[0].trim();
        if (secondsText === '*') {
          state.second.cronEvery = '1';
        } else if (secondsText.includes('/')) {
          state.second.cronEvery = '2';
          const secondsTexts = secondsText.split('/');
          // eslint-disable-next-line radix
          state.second.incrementStart = parseInt(secondsTexts[0]);
          // eslint-disable-next-line radix
          state.second.incrementIncrement = parseInt(secondsTexts[1]);
          // eslint-disable-next-line no-restricted-globals
        } else if (secondsText.includes(',') || isFinite(secondsText)) {
          state.second.cronEvery = '3';
          state.second.specificSpecific = secondsText
            .split(',')
            // eslint-disable-next-line radix
            .map(item => parseInt(item));
        } else if (secondsText.includes('-')) {
          state.second.cronEvery = '4';
          const secondsTexts = secondsText.split('-');
          // eslint-disable-next-line radix
          state.second.rangeStart = parseInt(secondsTexts[0]);
          // eslint-disable-next-line radix
          state.second.rangeEnd = parseInt(secondsTexts[1]);
        }
        // 解析minutes
        const minutesText = crons[1].trim();
        if (minutesText === '*') {
          state.minute.cronEvery = '1';
        } else if (minutesText.includes('/')) {
          state.minute.cronEvery = '2';
          const minutesTexts = minutesText.split('/');
          // eslint-disable-next-line radix
          state.minute.incrementStart = parseInt(minutesTexts[0]);
          // eslint-disable-next-line radix
          state.minute.incrementIncrement = parseInt(minutesTexts[1]);
          // eslint-disable-next-line no-restricted-globals
        } else if (minutesText.includes(',') || isFinite(minutesText)) {
          state.minute.cronEvery = '3';
          state.minute.specificSpecific = minutesText
            .split(',')
            // eslint-disable-next-line radix
            .map(item => parseInt(item));
        } else if (minutesText.includes('-')) {
          state.minute.cronEvery = '4';
          const minutesTexts = minutesText.split('-');
          // eslint-disable-next-line radix
          state.minute.rangeStart = parseInt(minutesTexts[0]);
          // eslint-disable-next-line radix
          state.minute.rangeEnd = parseInt(minutesTexts[1]);
        }
        // 解析hours
        const hoursText = crons[2].trim();
        if (hoursText === '*') {
          state.hour.cronEvery = '1';
        } else if (hoursText.includes('/')) {
          state.hour.cronEvery = '2';
          const hoursTexts = hoursText.split('/');
          // eslint-disable-next-line radix
          state.hour.incrementStart = parseInt(hoursTexts[0]);
          // eslint-disable-next-line radix
          state.hour.incrementIncrement = parseInt(hoursTexts[1]);
          // eslint-disable-next-line no-restricted-globals
        } else if (hoursText.includes(',') || isFinite(hoursText)) {
          state.hour.cronEvery = '3';
          state.hour.specificSpecific = hoursText
            .split(',')
            // eslint-disable-next-line radix
            .map(item => parseInt(item));
        } else if (hoursText.includes('-')) {
          state.hour.cronEvery = '4';
          const hoursTexts = hoursText.split('-');
          // eslint-disable-next-line radix
          state.hour.rangeStart = parseInt(hoursTexts[0]);
          // eslint-disable-next-line radix
          state.hour.rangeEnd = parseInt(hoursTexts[1]);
        }
        // 解析days weeks
        const daysText = crons[3].trim();
        const weeksText = crons[5].trim();
        if (daysText.includes('/')) {
          state.day.cronEvery = '3';
          const daysTexts = daysText.split('/');
          // eslint-disable-next-line radix
          state.day.incrementStart = parseInt(daysTexts[0]);
          // eslint-disable-next-line radix
          state.day.incrementIncrement = parseInt(daysTexts[1]);
          // eslint-disable-next-line no-restricted-globals
        } else if (daysText.includes(',') || isFinite(daysText)) {
          state.day.cronEvery = '5';
          state.day.specificSpecific = daysText
            .split(',')
            // eslint-disable-next-line radix
            .map(item => parseInt(item));
        } else if (daysText === 'L') {
          state.day.cronEvery = '6';
        } else if (daysText === 'LW') {
          state.day.cronEvery = '7';
        } else if (daysText.startsWith('L-')) {
          state.day.cronEvery = '9';
          // eslint-disable-next-line radix
          state.day.cronDaysBeforeEomMinus = parseInt(
            daysText.replaceAll('L-', ''),
          );
        } else if (daysText.endsWith('W')) {
          state.day.cronEvery = '10';
          // eslint-disable-next-line radix
          state.day.cronDaysNearestWeekday = parseInt(
            daysText.replaceAll('W', ''),
          );
        } else if (daysText === '?') {
          if (weeksText.includes('/')) {
            state.day.cronEvery = '2';
            const weeksTexts = weeksText.split('/');
            // eslint-disable-next-line radix
            state.week.incrementStart = parseInt(weeksTexts[0]);
            // eslint-disable-next-line radix
            state.week.incrementIncrement = parseInt(weeksTexts[1]);
            // eslint-disable-next-line no-restricted-globals
          } else if (weeksText.includes(',') || isFinite(weeksText)) {
            state.day.cronEvery = '4';
            state.week.specificSpecific = weeksText
              .split(',')
              .map(item => item);
          } else if (weeksText.includes('#')) {
            state.day.cronEvery = '11';
            const weeksTexts = weeksText.split('#');
            // eslint-disable-next-line radix
            state.week.cronNthDayDay = parseInt(weeksTexts[0]);
            // eslint-disable-next-line radix
            state.week.cronNthDayNth = parseInt(weeksTexts[1]);
          } else if (weeksText.endsWith('L')) {
            state.day.cronEvery = '8';
            // eslint-disable-next-line radix
            state.week.cronLastSpecificDomDay = parseInt(
              weeksText.replaceAll('L', ''),
            );
          }
        } else {
          state.day.cronEvery = '1';
        }

        // 解析months
        const monthsText = crons[4].trim();
        if (monthsText === '*') {
          state.month.cronEvery = '1';
        } else if (monthsText.includes('/')) {
          state.month.cronEvery = '2';
          const monthsTexts = monthsText.split('/');
          // eslint-disable-next-line radix
          state.month.incrementStart = parseInt(monthsTexts[0]);
          // eslint-disable-next-line radix
          state.month.incrementIncrement = parseInt(monthsTexts[1]);
          // eslint-disable-next-line no-restricted-globals
        } else if (monthsText.includes(',') || isFinite(monthsText)) {
          state.month.cronEvery = '3';
          state.month.specificSpecific = monthsText
            .split(',')
            // eslint-disable-next-line radix
            .map(item => parseInt(item));
        } else if (monthsText.includes('-')) {
          state.month.cronEvery = '4';
          const monthsTexts = monthsText.split('-');
          // eslint-disable-next-line radix
          state.month.rangeStart = parseInt(monthsTexts[0]);
          // eslint-disable-next-line radix
          state.month.rangeEnd = parseInt(monthsTexts[1]);
        }
        // 解析years
        const yearsText = crons[6].trim();
        if (yearsText === '*') {
          state.year.cronEvery = '1';
        } else if (yearsText.includes('/')) {
          state.year.cronEvery = '2';
          const yearsTexts = yearsText.split('/');
          // eslint-disable-next-line radix
          state.year.incrementStart = parseInt(yearsTexts[0]);
          // eslint-disable-next-line radix
          state.year.incrementIncrement = parseInt(yearsTexts[1]);
          // eslint-disable-next-line no-restricted-globals
        } else if (yearsText.includes(',') || isFinite(yearsText)) {
          state.year.cronEvery = '3';
          state.year.specificSpecific = yearsText
            .split(',')
            // eslint-disable-next-line radix
            .map(item => parseInt(item));
        } else if (yearsText.includes('-')) {
          state.year.cronEvery = '4';
          const yearsTexts = yearsText.split('-');
          // eslint-disable-next-line radix
          state.year.rangeStart = parseInt(yearsTexts[0]);
          // eslint-disable-next-line radix
          state.year.rangeEnd = parseInt(yearsTexts[1]);
        }
      },
      {
        immediate: true,
      },
    );
    const getValue = () => {
      return state.cron;
    };
    const close = () => {
      emit('close');
    };
    const handleChange = () => {
      emit('change', state.cron);
      close();
    };
    const rest = data => {
      // eslint-disable-next-line no-restricted-syntax
      for (const i in data) {
        if (data[i] instanceof Object) {
          this.rest(data[i]);
        } else {
          // eslint-disable-next-line default-case
          switch (typeof data[i]) {
            case 'object':
              data[i] = [];
              break;
            case 'string':
              data[i] = '';
              break;
          }
        }
      }
    };
    return {
      state,
      getValue,
      close,
      handleChange,
      rest,
    };
  },
});
</script>
