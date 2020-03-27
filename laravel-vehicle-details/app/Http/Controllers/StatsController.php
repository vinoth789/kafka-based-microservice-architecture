<?php

namespace App\Http\Controllers;

use App\Inventory;
use App\Stat;
use Illuminate\Http\Request;

class StatsController extends Controller
{
    /**
     * Get stats
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        // $stats = Stat::selectRaw('count(make) as total, stats.*')
        //     ->groupBy('make')
        //     ->groupBy('model')
        //     ->orderBy('total', 'desc')
        //     ->get();
        $stats = Stat::all();

        return view('stats.index', ['stats' => $stats]);
    }
}
