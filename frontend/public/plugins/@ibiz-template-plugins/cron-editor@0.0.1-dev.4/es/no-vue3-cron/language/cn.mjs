"use strict";
var cn = {
  Seconds: {
    name: "\u79D2",
    every: "\u6BCF\u4E00\u79D2\u949F",
    interval: ["\u6BCF\u9694", "\u79D2\u6267\u884C \u4ECE", "\u79D2\u5F00\u59CB"],
    specific: "\u5177\u4F53\u79D2\u6570(\u53EF\u591A\u9009)",
    cycle: ["\u5468\u671F\u4ECE", "\u5230", "\u79D2"]
  },
  Minutes: {
    name: "\u5206",
    every: "\u6BCF\u4E00\u5206\u949F",
    interval: ["\u6BCF\u9694", "\u5206\u6267\u884C \u4ECE", "\u5206\u5F00\u59CB"],
    specific: "\u5177\u4F53\u5206\u949F\u6570(\u53EF\u591A\u9009)",
    cycle: ["\u5468\u671F\u4ECE", "\u5230", "\u5206"]
  },
  Hours: {
    name: "\u65F6",
    every: "\u6BCF\u4E00\u5C0F\u65F6",
    interval: ["\u6BCF\u9694", "\u5C0F\u65F6\u6267\u884C \u4ECE", "\u5C0F\u65F6\u5F00\u59CB"],
    specific: "\u5177\u4F53\u5C0F\u65F6\u6570(\u53EF\u591A\u9009)",
    cycle: ["\u5468\u671F\u4ECE", "\u5230", "\u5C0F\u65F6"]
  },
  Day: {
    name: "\u5929",
    every: "\u6BCF\u4E00\u5929",
    intervalWeek: ["\u6BCF\u9694", "\u5929\u6267\u884C \u4ECE", "\u5F00\u59CB"],
    intervalDay: ["\u6BCF\u9694", "\u5929\u6267\u884C \u4ECE", "\u65E5\u5F00\u59CB"],
    specificWeek: "\u5177\u4F53\u661F\u671F\u51E0(\u53EF\u591A\u9009)",
    specificDay: "\u5177\u4F53\u5929\u6570(\u53EF\u591A\u9009)",
    lastDay: "\u5728\u8FD9\u4E2A\u6708\u7684\u6700\u540E\u4E00\u5929",
    lastWeekday: "\u5728\u8FD9\u4E2A\u6708\u7684\u6700\u540E\u4E00\u4E2A\u5DE5\u4F5C\u65E5",
    lastWeek: ["\u5728\u8FD9\u4E2A\u6708\u7684\u6700\u540E\u4E00\u4E2A"],
    beforeEndMonth: ["\u5728\u672C\u6708\u5E95\u524D", "\u5929"],
    nearestWeekday: ["\u6700\u8FD1\u7684\u5DE5\u4F5C\u65E5\uFF08\u5468\u4E00\u81F3\u5468\u4E94\uFF09\u81F3\u672C\u6708", "\u65E5"],
    someWeekday: ["\u5728\u8FD9\u4E2A\u6708\u7684\u7B2C", ""]
  },
  Week: ["\u5929", "\u4E00", "\u4E8C", "\u4E09", "\u56DB", "\u4E94", "\u516D"].map((val) => "\u661F\u671F".concat(val)),
  Month: {
    name: "\u6708",
    every: "\u6BCF\u4E00\u6708",
    interval: ["\u6BCF\u9694", "\u6708\u6267\u884C \u4ECE", "\u6708\u5F00\u59CB"],
    specific: "\u5177\u4F53\u6708\u6570(\u53EF\u591A\u9009)",
    cycle: ["\u4ECE", "\u5230", "\u6708\u4E4B\u95F4\u7684\u6BCF\u4E2A\u6708"]
  },
  Year: {
    name: "\u5E74",
    every: "\u6BCF\u4E00\u5E74",
    interval: ["\u6BCF\u9694", "\u5E74\u6267\u884C \u4ECE", "\u5E74\u5F00\u59CB"],
    specific: "\u5177\u4F53\u5E74\u4EFD(\u53EF\u591A\u9009)",
    cycle: ["\u4ECE", "\u5230", "\u5E74\u4E4B\u95F4\u7684\u6BCF\u4E00\u5E74"]
  },
  Save: "\u4FDD\u5B58",
  Close: "\u5173\u95ED"
};

export { cn as default };
